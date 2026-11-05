package base.project.service;

import java.math.BigDecimal;

public class ShopPriceService {

    private final BigDecimal priceForKilo;

    private BigDecimal currentAvailableDiscount;

    private final BigDecimal discountStep;

    public BigDecimal getPriceForKilo() {
        return priceForKilo;
    }


    public BigDecimal getDiscountStep() {
        return discountStep;
    }

    public ShopPriceService(BigDecimal priceForKilo, BigDecimal currentAvailableDiscount, BigDecimal discountStep) {
        this.priceForKilo = priceForKilo;
        this.currentAvailableDiscount = currentAvailableDiscount;
        this.discountStep = discountStep;
    }

    private void decreaseCurrentDiscount() {
        if (currentAvailableDiscount.compareTo(discountStep) < 0) {
            currentAvailableDiscount = BigDecimal.ZERO;
        } else {
            currentAvailableDiscount = currentAvailableDiscount.subtract(discountStep);
        }
    }

    public BigDecimal getCurrentDiscountAndDecreaseForNextClient() {
        if (currentAvailableDiscount.compareTo(BigDecimal.ZERO) == 0) return currentAvailableDiscount;
        BigDecimal currentDiscountTemp = currentAvailableDiscount;
        decreaseCurrentDiscount();
        return currentDiscountTemp;
    }
}
