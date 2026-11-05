package base.project.repository;

import base.project.model.OrderCheckout;
import base.project.model.OrderIncoming;
import base.project.model.PreferableFileType;
import base.project.service.OrdersParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OrdersAnyFileRepository {

    private String inputFile;
    private String outputFile;
    private String delimeter;

    public OrdersAnyFileRepository(PreferableFileType preferableFileType) {
        switch (preferableFileType) {
            case TXT -> {
                inputFile = Const.INPUT_TXT_FILE_NAME;
                outputFile = Const.OUTPUT_TXT_FILE_NAME;
                delimeter = Const.TXT_DELIMETER;
            }
            case NOEXT -> {
                inputFile = Const.INPUT_NOEXT_FILE_NAME;
                outputFile = Const.OUTPUT_NOEXT_FILE_NAME;
                delimeter = Const.NOEXT_DELIMETER;
            }
        }
    }


    public ArrayList<OrderIncoming> getOrdersFromFile() throws IOException {
        ArrayList<OrderIncoming> list = new ArrayList<>();
        for (String line : Files.readAllLines(Paths.get(inputFile))) {
            list.add(OrdersParser.parse(line, delimeter));
        }
        return list;
    }


    public void submitOrdersToFile(ArrayList<OrderCheckout> orders) throws IOException {
        List<String> ordersAsString = orders.stream().map(OrderCheckout::toString).toList();
        Files.write(Paths.get(outputFile), ordersAsString);
    }

}
