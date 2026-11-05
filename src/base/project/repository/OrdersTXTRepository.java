package base.project.repository;

import base.project.model.OrderCheckout;
import base.project.model.OrderIncoming;
import base.project.service.OrdersParser;
import base.project.service.TxtReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OrdersTXTRepository implements OrdersRepository {

    TxtReaderService txtReaderService = new TxtReaderService();

    @Override
    public ArrayList<OrderIncoming> getOrders() {
        ArrayList<OrderIncoming> list = new ArrayList<>();
        try {
            List<String> listFromTxtfile = txtReaderService.getAllLinesFromTxtFile(Const.INPUT_TXT_FILE_NAME);
            for (String line : listFromTxtfile) {
                list.add(OrdersParser.parse(line, Const.TXT_DELIMETER));
            }
        } catch (IOException e) {
            System.err.println("could not open file " + Const.INPUT_TXT_FILE_NAME);
        }
        return list;
    }

    @Override
    public void submitOrders(ArrayList<OrderCheckout> orders) {

        List<String> ordersAsString = orders.stream().map(OrderCheckout::toString).toList();

        try {
            Files.write(Paths.get(Const.OUTPUT_TXT_FILE_NAME), ordersAsString);
        } catch (IOException e) {
            System.err.println("could not open file " + Const.OUTPUT_TXT_FILE_NAME);
        }

    }


}
