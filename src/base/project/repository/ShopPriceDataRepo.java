package base.project.repository;

import io.github.cdimascio.dotenv.Dotenv;

import java.math.BigDecimal;

public class ShopPriceDataRepo {

    private final Dotenv dotenv = Dotenv.load();


    public BigDecimal getDefaultPriceForKilo() {
        return new BigDecimal(dotenv.get("PRICE_FOR_KILO"));
    }

    public BigDecimal getDefaultStartDiscount() {
        return new BigDecimal(dotenv.get("DEFAULT_START_DISCOUNT"));
    }

    public BigDecimal getDefaultDiscountStep() {
        return new BigDecimal(dotenv.get("DISCOUNT_STEP"));
    }
}
