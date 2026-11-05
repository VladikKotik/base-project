package service;

import config.FileRepositoryFactory;
import model.Client;
import model.OrderCheckout;
import model.OrderIncoming;
import model.PreferableFileType;
import repository.OrdersRepository;

import java.math.BigDecimal;
import java.util.*;

public class MainShopService {

    private OrdersRepository inputRepo;

    private OrdersRepository outputRepo;

    private ClientService clientService;


    public void processOrders(PreferableFileType inputPreferableType,PreferableFileType outputPreferableType){

        initOrdersRepo(inputPreferableType,outputPreferableType);

        ArrayList<OrderCheckout> ordersReadyToCheckout = new ArrayList<>();

        List<OrderIncoming> sortedOrdersByTime = inputRepo.getOrders().stream().sorted().toList();

        initClientsService(sortedOrdersByTime);

        Set<String> clientsNames = clientService.getClients().keySet();

        for (String clientName : clientsNames) {
            BigDecimal totalAmountOfGoodsForClient = sortedOrdersByTime.stream()
                    .filter(it -> it.getClientName().equals(clientName))
                    .map(OrderIncoming::getAmountOfGoods)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            Client clientosina = clientService.getClients().get(clientName);


            //количество кг × цена за кг × (1 − скидка)
            BigDecimal totalOrderSumm = totalAmountOfGoodsForClient.multiply(ShopPriceData.PRICE_FOR_KILO.multiply(BigDecimal.ONE.subtract(clientosina.getPersonalDiscount())));

            ordersReadyToCheckout.add(new OrderCheckout(clientName,totalOrderSumm));
        }

        outputRepo.submitOrders(ordersReadyToCheckout);

    }

    private void initOrdersRepo(PreferableFileType inputPreferableType,PreferableFileType outputPreferableType){
        inputRepo = FileRepositoryFactory.getOrdersRepository(inputPreferableType);
        if (inputPreferableType==outputPreferableType) {
            outputRepo = inputRepo;
        }else {
            outputRepo = FileRepositoryFactory.getOrdersRepository(outputPreferableType);
        }
    }

    private void initClientsService(List<OrderIncoming> sortedOrdersByTime){
        clientService = new ClientService();
        clientService.initClientsFromOrders(sortedOrdersByTime);
    }

}
