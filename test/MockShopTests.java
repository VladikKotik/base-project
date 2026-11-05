import model.OrderIncoming;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.OrdersRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockShopTests {

    @Mock
    OrdersRepository ordersRepository;

    @Test
    public void shopTest(){
        ArrayList<OrderIncoming> orders = new ArrayList<>(List.of(
                new OrderIncoming("Industrial",     new BigDecimal("8800"),  LocalDateTime.parse("2021-02-09T16:00:22")),
                new OrderIncoming("Power Engineer", new BigDecimal("17480"), LocalDateTime.parse("2021-02-09T08:42:59")),
                new OrderIncoming("Mosque",         new BigDecimal("33120"), LocalDateTime.parse("2021-02-09T10:48:34")),
                new OrderIncoming("Recovery",       new BigDecimal("11340"), LocalDateTime.parse("2021-02-09T08:19:22")),
                new OrderIncoming("Atomic",         new BigDecimal("12500"), LocalDateTime.parse("2021-02-09T11:41:31")),
                new OrderIncoming("Preparatory",    new BigDecimal("21410"), LocalDateTime.parse("2021-02-09T08:57:51")),
                new OrderIncoming("Resident",       new BigDecimal("5610"),  LocalDateTime.parse("2021-02-09T20:26:03")),
                new OrderIncoming("Fossil",         new BigDecimal("19600"), LocalDateTime.parse("2021-02-09T09:50:10")),
                new OrderIncoming("Power Engineer", new BigDecimal("24600"), LocalDateTime.parse("2021-02-10T08:53:25")),
                new OrderIncoming("Carryover",      new BigDecimal("29670"), LocalDateTime.parse("2021-02-09T17:39:17")),
                new OrderIncoming("Electricity",    new BigDecimal("3680"),  LocalDateTime.parse("2021-02-09T12:32:48")),
                new OrderIncoming("Ancillary",      new BigDecimal("30000"), LocalDateTime.parse("2021-02-09T21:10:34")),
                new OrderIncoming("Pyramid",        new BigDecimal("10100"), LocalDateTime.parse("2021-02-09T09:11:43"))
        ));
        when(ordersRepository.getOrders()).thenReturn(orders);



    }
}
