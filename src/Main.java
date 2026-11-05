import model.PreferableFileType;
import repository.OrdersRepository;
import service.ClientService;
import service.InitService;
import service.MainShopService;

public class Main {
    public static void main(String[] args) {

        InitService.initOrdersRepo(PreferableFileType.TXT,PreferableFileType.TXT);

        OrdersRepository inputRepo = InitService.getInputRepo();
        OrdersRepository outputRepo = InitService.getOutputRepo();

        ClientService clientService = InitService.initClientsService(inputRepo);

        MainShopService mss = new MainShopService(inputRepo,outputRepo,clientService);

        mss.processOrders();

    }


}
