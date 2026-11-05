import model.PreferableFileType;
import model.ShopPriceData;
import repository.OrdersRepository;
import repository.ShopPriceDataRepo;
import service.ClientService;
import service.InitService;
import service.MainShopService;

public class Main {
    public static void main(String[] args) {

        InitService.initOrdersRepo(PreferableFileType.TXT,PreferableFileType.TXT);

        OrdersRepository inputRepo = InitService.getInputRepo();
        OrdersRepository outputRepo = InitService.getOutputRepo();

        ShopPriceDataRepo shopPriceDataRepo = new ShopPriceDataRepo();

        ShopPriceData.setDefaultValues(shopPriceDataRepo.getDefaultPriceForKilo(),shopPriceDataRepo.getDefaultStartDiscount(),shopPriceDataRepo.getDefaultDiscountStep());

        ClientService clientService = InitService.initClientsService(inputRepo);

        MainShopService mss = new MainShopService(inputRepo,outputRepo,clientService);

        mss.processOrders();

    }


}
