package service;

import config.FileRepositoryFactory;
import model.OrderIncoming;
import model.PreferableFileType;
import repository.OrdersRepository;

import java.util.List;

public class InitService {

    private static OrdersRepository inputRepo;
    private static OrdersRepository outputRepo;


    public static void initOrdersRepo(PreferableFileType inputPreferableType, PreferableFileType outputPreferableType){
        inputRepo = FileRepositoryFactory.getOrdersRepository(inputPreferableType);
        if (inputPreferableType==outputPreferableType) {
            outputRepo = inputRepo;
        }else {
            outputRepo = FileRepositoryFactory.getOrdersRepository(outputPreferableType);
        }
    }

    public static OrdersRepository getInputRepo() {
        return inputRepo;
    }

    public static OrdersRepository getOutputRepo() {
        return outputRepo;
    }

    public static ClientService initClientsService(OrdersRepository inputRepo){
        List<OrderIncoming> sortedOrdersByTime = inputRepo.getOrders().stream().sorted().toList();
        ClientService clientService = new ClientService();
        clientService.initClientsFromOrders(sortedOrdersByTime);
        return clientService;
    }
}
