package service;

import model.Client;
import model.OrderIncoming;
import model.ShopPriceData;

import java.util.HashMap;
import java.util.List;

public class ClientService {
    private final HashMap<String, Client> clients = new HashMap<>();

    public void initClientsFromOrders(List<OrderIncoming> orders){
        for (OrderIncoming order : orders) {
            if(!clients.containsKey(order.getClientName())){
                String clientName = order.getClientName();
                clients.put(clientName, new Client(clientName, ShopPriceData.getCurrentDiscount()));
            }
        }
    }

    public HashMap<String, Client> getClients() {
        return clients;
    }

}
