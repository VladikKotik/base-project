package model;

import java.math.BigDecimal;

public class ShopPriceData {

    public static BigDecimal priceForKilo;// = BigDecimal.valueOf(10);

    private static BigDecimal currentAvailableDiscount;// = BigDecimal.valueOf(0.5);

    private static BigDecimal discountStep;// = BigDecimal.valueOf(0.05);

    private static boolean isPossibleToSetInitValues = true;

    public static void setDefaultValues(BigDecimal inPriceForKilo, BigDecimal discountStart, BigDecimal inDiscountStep){
        if(isPossibleToSetInitValues){
            priceForKilo = inPriceForKilo;
            currentAvailableDiscount = discountStart;
            discountStep = inDiscountStep;
        }
        isPossibleToSetInitValues=false;
    }


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
