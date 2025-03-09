package fooddeliveryapp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class PickUpOrderCommand {

    private String deliveryId;
    private String driver;
    private Address address;
}
