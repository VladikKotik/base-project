package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;

public class OrderIncoming  implements Comparable{

    private String clientName;

    private BigDecimal amountOfGoods;

    private LocalDateTime orderDate;

    public OrderIncoming(String clientName, BigDecimal amountOfGoods, LocalDateTime orderDate) {
        this.clientName=clientName;
        this.amountOfGoods=amountOfGoods;
        this.orderDate = orderDate;
    }


    @Override
    public int compareTo(Object o) {
        if (!(o instanceof OrderIncoming order)) {
            throw new ClassCastException("Объект не является сотрудником (OrderIncoming)");
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
