package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderPickedUp extends AbstractEvent {

    private String deliveryId;
    private String driver;

    public OrderPickedUp(Delivery aggregate) {
        super(aggregate);
    }

    public OrderPickedUp() {
        super();
    }
}
//>>> DDD / Domain Event
