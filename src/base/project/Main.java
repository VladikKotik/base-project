package base.project;

import base.project.model.PreferableFileType;
import base.project.repository.OrdersAnyFileRepository;
import base.project.repository.OrdersRepoImpl;
import base.project.repository.OrdersRepository;
import base.project.repository.ShopPriceDataRepo;
import base.project.service.ClientService;
import base.project.service.MainShopService;
import base.project.service.ShopPriceService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        OrdersRepository inputRepo = new OrdersRepoImpl(new OrdersAnyFileRepository(PreferableFileType.NOEXT));
        OrdersRepository outputRepo = new OrdersRepoImpl(new OrdersAnyFileRepository(PreferableFileType.TXT));

        ShopPriceDataRepo shopPriceDataRepo = new ShopPriceDataRepo();

        ShopPriceService shopPriceService = new ShopPriceService(shopPriceDataRepo.getDefaultPriceForKilo(), shopPriceDataRepo.getDefaultStartDiscount(), shopPriceDataRepo.getDefaultDiscountStep());

        ClientService clientService = new ClientService(shopPriceService);
        clientService.initClientsFromOrders(inputRepo.getOrders());

        MainShopService mss = new MainShopService(inputRepo, outputRepo, clientService, shopPriceService);

        mss.processOrders();

    }


}
