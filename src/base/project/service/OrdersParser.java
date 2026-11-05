package base.project.service;

import base.project.model.OrderIncoming;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrdersParser {
    public static OrderIncoming parse(String line, String delimeter) {
        String[] parts = line.split(delimeter);
        return new OrderIncoming(
                parts[1].trim(),
                new BigDecimal(parts[2].trim()),
                LocalDateTime.parse(parts[0].trim())
        );
    }
}
