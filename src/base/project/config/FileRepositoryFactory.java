package base.project.config;

import base.project.model.PreferableFileType;
import base.project.repository.OrdersNOEXTRepository;
import base.project.repository.OrdersRepository;
import base.project.repository.OrdersTXTRepository;

public class FileRepositoryFactory {
    public static OrdersRepository getOrdersRepository(PreferableFileType preferableFileType) {
        return switch (preferableFileType) {
            case TXT -> new OrdersTXTRepository();
            case NOEXT -> new OrdersNOEXTRepository();
        };
    }
}
