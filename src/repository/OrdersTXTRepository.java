package repository;

import model.OrderCheckout;
import model.OrderIncoming;
import service.OrdersParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OrdersTXTRepository  implements OrdersRepository{

    @Override
    public ArrayList<OrderIncoming> getOrders() {
        ArrayList<OrderIncoming> list = new ArrayList<>();
        try {
            for (String line : Files.readAllLines(Paths.get(Const.INPUT_TXT_FILE_NAME))) {
                list.add(OrdersParser.parse(line,Const.TXT_DELIMETER));
            }
        } catch (IOException e) {
            System.err.println("could not open file "+ Const.INPUT_TXT_FILE_NAME);
        }
        return list;
    }

    @Override
    public void submitOrders(ArrayList<OrderCheckout> orders) {

        List<String> ordersAsString = orders.stream().map(OrderCheckout::toString).toList();

        try {
            Files.write(Paths.get(Const.OUTPUT_TXT_FILE_NAME), ordersAsString);
        } catch (IOException e) {
            System.err.println("could not open file "+ Const.OUTPUT_TXT_FILE_NAME);
        }

    }



}
