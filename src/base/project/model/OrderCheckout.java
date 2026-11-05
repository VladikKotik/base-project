package base.project.model;

import java.math.BigDecimal;

public class OrderCheckout {

    private final String clientName;

    private final BigDecimal totalPrice;

    public OrderCheckout(String clientName, BigDecimal totalPrice) {
        this.clientName = clientName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString(){
        return clientName+" - "+totalPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public String getClientName() {
        return clientName;
    }
}
