package base.project.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderIncoming implements Comparable {

    private final String clientName;

    private final BigDecimal amountOfGoods;

    private final LocalDateTime orderDate;

    public OrderIncoming(String clientName, BigDecimal amountOfGoods, LocalDateTime orderDate) {
        this.clientName = clientName;
        this.amountOfGoods = amountOfGoods;
        this.orderDate = orderDate;
    }


    @Override
    public int compareTo(Object o) {
        if (!(o instanceof OrderIncoming order)) {
            throw new ClassCastException("Объект не является заказом (OrderIncoming)");
        }
        return this.orderDate.compareTo(order.orderDate);
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getClientName() {
        return clientName;
    }

    public BigDecimal getAmountOfGoods() {
        return amountOfGoods;
    }
}
