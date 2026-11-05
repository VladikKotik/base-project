package repository;

import model.OrderCheckout;
import model.OrderIncoming;

import java.util.ArrayList;

public interface OrdersRepository {

    ArrayList<OrderIncoming> getOrders();

    void submitOrders(ArrayList<OrderCheckout> orders);

}
