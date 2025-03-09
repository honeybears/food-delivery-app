package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class RestaurantRegistered extends AbstractEvent {

    private String restaurantId;
    private String name;

    public RestaurantRegistered(Restaurant aggregate) {
        super(aggregate);
    }

    public RestaurantRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
