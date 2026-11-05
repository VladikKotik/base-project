package base.project.service;

import base.project.model.Client;
import base.project.model.OrderCheckout;
import base.project.model.OrderIncoming;
import base.project.repository.OrdersRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class MainShopService {

    private final OrdersRepository inputRepo;

    private final OrdersRepository outputRepo;

    private final ClientService clientService;

    private final ShopPriceService shopPriceService;

    private OrderCheckout testCheckoutOrder = new OrderCheckout("", BigDecimal.ZERO);

    public MainShopService(OrdersRepository inputRepo, OrdersRepository outputRepo, ClientService clientService, ShopPriceService shopPriceService) {
        this.inputRepo = inputRepo;
        this.outputRepo = outputRepo;
        this.clientService = clientService;
        this.shopPriceService = shopPriceService;
    }

    public List<OrderCheckout> processOrders() throws IOException {

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
            BigDecimal totalOrderSumm = (totalAmountOfGoodsForClient.multiply(shopPriceService.getPriceForKilo().multiply(BigDecimal.ONE.subtract(clientosina.getPersonalDiscount())))).setScale(2, RoundingMode.HALF_UP);

            ordersReadyToCheckout.add(new OrderCheckout(clientName, totalOrderSumm));
        }


        outputRepo.submitOrders(ordersReadyToCheckout);
        return ordersReadyToCheckout;
    }


}
