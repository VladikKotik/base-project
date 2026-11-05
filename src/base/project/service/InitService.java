package base.project.service;

import base.project.config.FileRepositoryFactory;
import base.project.model.OrderIncoming;
import base.project.model.PreferableFileType;
import base.project.repository.OrdersRepository;

import java.util.Comparator;
import java.util.List;

public class InitService {

    private static OrdersRepository inputRepo;
    private static OrdersRepository outputRepo;

    public static void initOrdersRepo(PreferableFileType inputPreferableType, PreferableFileType outputPreferableType) {
        inputRepo = FileRepositoryFactory.getOrdersRepository(inputPreferableType);
        if (inputPreferableType == outputPreferableType) {
            outputRepo = inputRepo;
        } else {
            outputRepo = FileRepositoryFactory.getOrdersRepository(outputPreferableType);
        }
    }

    public static OrdersRepository getInputRepo() {
        return inputRepo;
    }

    public static OrdersRepository getOutputRepo() {
        return outputRepo;
    }

    public static ClientService initClientsService(OrdersRepository inputRepo, ShopPriceService shopPriceService) {
        List<OrderIncoming> sortedOrdersByTime = inputRepo.getOrders().stream().sorted(Comparator.naturalOrder()).toList();
        ClientService clientService = new ClientService(shopPriceService);
        clientService.initClientsFromOrders(sortedOrdersByTime);
        return clientService;
    }
}
