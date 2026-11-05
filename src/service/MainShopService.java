package service;

import model.Client;
import model.OrderCheckout;
import model.OrderIncoming;
import repository.OrdersRepository;
import model.ShopPriceData;

import java.math.BigDecimal;
import java.util.*;

public class MainShopService {

    private OrdersRepository inputRepo;

    private OrdersRepository outputRepo;

    private ClientService clientService;

    private OrderCheckout testCheckoutOrder = new OrderCheckout("",BigDecimal.ZERO);

    public MainShopService(OrdersRepository inputRepo, OrdersRepository outputRepo, ClientService clientService) {
        this.inputRepo = inputRepo;
        this.outputRepo = outputRepo;
        this.clientService = clientService;
    }

    public void processOrders(){

        ArrayList<OrderCheckout> ordersReadyToCheckout = new ArrayList<>();

        List<OrderIncoming> orders = inputRepo.getOrders();

        //ваще мы типа как будто 2 раза зря ходим за заказами в репозиторий, НО потом в след версиях
        // мы клиентов будем дергать откуда-нибудь по нормальному, а не из заказов

        Set<String> clientsNames = clientService.getClients().keySet();

        for (String clientName : clientsNames) {
            BigDecimal totalAmountOfGoodsForClient = orders.stream()
                    .filter(it -> it.getClientName().equals(clientName))
                    .map(OrderIncoming::getAmountOfGoods)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            Client clientosina = clientService.getClients().get(clientName);

            //количество кг × цена за кг × (1 − скидка)
            BigDecimal totalOrderSumm = totalAmountOfGoodsForClient.multiply(ShopPriceData.priceForKilo.multiply(BigDecimal.ONE.subtract(clientosina.getPersonalDiscount())));

            ordersReadyToCheckout.add(new OrderCheckout(clientName,totalOrderSumm));
        }

        //костыль для мок тестов, но я ниче не хочу возвращать из этого метода, может и неправильно это
        testCheckoutOrder = ordersReadyToCheckout.get(0);


        outputRepo.submitOrders(ordersReadyToCheckout);
    }

    public OrderCheckout getTestOrder(){
        return testCheckoutOrder;
    }

}
