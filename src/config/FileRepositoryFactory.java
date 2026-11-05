package config;

import model.PreferableFileType;
import repository.OrdersNOEXTRepository;
import repository.OrdersRepository;
import repository.OrdersTXTRepository;

public class FileRepositoryFactory {
    public static OrdersRepository getOrdersRepository(PreferableFileType preferableFileType){
        return switch (preferableFileType) {
            case TXT ->  new OrdersTXTRepository();
            case NOEXT -> new OrdersNOEXTRepository();
        };
    }
}
