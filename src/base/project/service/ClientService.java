package base.project.service;

import base.project.model.Client;
import base.project.model.OrderIncoming;

import java.util.HashMap;
import java.util.List;

public class ClientService {
    private final HashMap<String, Client> clients = new HashMap<>();

    private final ShopPriceService shopPriceService;

    public ClientService(ShopPriceService shopPriceService) {
        this.shopPriceService = shopPriceService;
    }

    public void initClientsFromOrders(List<OrderIncoming> orders) {
        for (OrderIncoming order : orders) {
            if (!clients.containsKey(order.getClientName())) {
                String clientName = order.getClientName();
                clients.put(clientName, new Client(clientName, shopPriceService.getCurrentDiscountAndDecreaseForNextClient()));
            }
        }
    }

    public HashMap<String, Client> getClients() {
        return clients;
    }

}
