package base.project.repository;

import base.project.model.OrderCheckout;
import base.project.model.OrderIncoming;

import java.util.ArrayList;

public interface OrdersRepository {

    ArrayList<OrderIncoming> getOrders();

    void submitOrders(ArrayList<OrderCheckout> orders);

}
