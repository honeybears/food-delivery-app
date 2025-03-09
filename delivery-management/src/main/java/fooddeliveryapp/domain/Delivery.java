package fooddeliveryapp.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import fooddeliveryapp.DeliveryManagementApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    private String deliveryId;

    private String driver;

    private Address address;

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryManagementApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public void pickUpOrder(PickUpOrderCommand pickUpOrderCommand) {
        //implement business logic here:

        OrderPickedUp orderPickedUp = new OrderPickedUp(this);
        orderPickedUp.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
