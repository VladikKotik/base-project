import config.FileRepositoryFactory;
import model.PreferableFileType;
import service.MainShopService;
import service.TaskSalvationService;

public class Main {
    public static void main(String[] args) {
        MainShopService mss = new MainShopService();
        mss.processOrders(PreferableFileType.NOEXT,PreferableFileType.NOEXT);

    }


}
