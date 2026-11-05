package base.project;

import base.project.model.PreferableFileType;
import base.project.repository.OrdersRepository;
import base.project.repository.ShopPriceDataRepo;
import base.project.service.ClientService;
import base.project.service.InitService;
import base.project.service.MainShopService;
import base.project.service.ShopPriceService;

public class Main {
    public static void main(String[] args) {

        InitService.initOrdersRepo(PreferableFileType.TXT, PreferableFileType.TXT);

        OrdersRepository inputRepo = InitService.getInputRepo();
        OrdersRepository outputRepo = InitService.getOutputRepo();

        ShopPriceDataRepo shopPriceDataRepo = new ShopPriceDataRepo();

        ShopPriceService shopPriceService = new ShopPriceService(shopPriceDataRepo.getDefaultPriceForKilo(), shopPriceDataRepo.getDefaultStartDiscount(), shopPriceDataRepo.getDefaultDiscountStep());

        ClientService clientService = InitService.initClientsService(inputRepo,shopPriceService);

        MainShopService mss = new MainShopService(inputRepo, outputRepo, clientService, shopPriceService);

        mss.processOrders();

    }


}
