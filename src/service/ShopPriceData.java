package service;

import java.math.BigDecimal;

public class ShopPriceData {

    public static final BigDecimal PRICE_FOR_KILO = BigDecimal.valueOf(10);

    private static BigDecimal currentAvailableDiscount = BigDecimal.valueOf(0.5);

    private static final BigDecimal discountStep = BigDecimal.valueOf(0.05);

    private static void decreaseCurrentDiscount(){
        currentAvailableDiscount = currentAvailableDiscount.subtract(discountStep);
    }

    public static BigDecimal getCurrentDiscount() {
        if(currentAvailableDiscount.compareTo(BigDecimal.ZERO)==0) return currentAvailableDiscount;
        BigDecimal currentDiscountTemp = currentAvailableDiscount;
        decreaseCurrentDiscount();
        return currentDiscountTemp;
    }
}
