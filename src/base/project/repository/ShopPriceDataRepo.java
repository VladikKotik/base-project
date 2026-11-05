package base.project.repository;

import java.math.BigDecimal;

public class ShopPriceDataRepo {
    public BigDecimal getDefaultPriceForKilo() {
        return BigDecimal.valueOf(100);
    }

    public BigDecimal getDefaultStartDiscount() {
        return BigDecimal.valueOf(0.5);
    }

    public BigDecimal getDefaultDiscountStep() {
        return BigDecimal.valueOf(0.05);
    }
}
