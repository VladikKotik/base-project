package base.project.repository;

import base.project.model.OrderCheckout;
import base.project.model.OrderIncoming;

import java.io.IOException;
import java.util.ArrayList;

public interface OrdersRepository {

    ArrayList<OrderIncoming> getOrders() throws IOException;

    void submitOrders(ArrayList<OrderCheckout> orders) throws IOException;

}
