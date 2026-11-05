package model;

import java.math.BigDecimal;

public class OrderCheckout {

    private String clientName;

    private BigDecimal totalPrice;

    public OrderCheckout(String clientName, BigDecimal totalPrice) {
        this.clientName = clientName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString(){
        return clientName+" - "+totalPrice;
    }
}
