package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentCompleted extends AbstractEvent {

    private String paymentId;
    private Money amount;

    public PaymentCompleted(Payment aggregate) {
        super(aggregate);
    }

    public PaymentCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
