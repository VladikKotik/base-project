package base.project.repository;

import base.project.model.OrderCheckout;
import base.project.model.OrderIncoming;

import java.io.IOException;
import java.util.ArrayList;

public class OrdersRepoImpl implements OrdersRepository {

    private OrdersAnyFileRepository ordersAnyFileRepository;

    public OrdersRepoImpl(OrdersAnyFileRepository ordersAnyFileRepository) {
        this.ordersAnyFileRepository = ordersAnyFileRepository;
    }

    @Override
    public ArrayList<OrderIncoming> getOrders() throws IOException {
        return ordersAnyFileRepository.getOrdersFromFile();
    }

    @Override
    public void submitOrders(ArrayList<OrderCheckout> orders) throws IOException {
        ordersAnyFileRepository.submitOrdersToFile(orders);
    }
}
