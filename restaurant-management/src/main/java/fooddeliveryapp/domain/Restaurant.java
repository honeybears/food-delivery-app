package fooddeliveryapp.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import fooddeliveryapp.RestaurantManagementApplication;
import fooddeliveryapp.domain.RestaurantRegistered;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Restaurant_table")
@Data
//<<< DDD / Aggregate Root
public class Restaurant {

    @Id
    private String restaurantId;

    private String name;

    private Address address;

    @PostPersist
    public void onPostPersist() {
        RestaurantRegistered restaurantRegistered = new RestaurantRegistered(
            this
        );
        restaurantRegistered.publishAfterCommit();
    }

    public static RestaurantRepository repository() {
        RestaurantRepository restaurantRepository = RestaurantManagementApplication.applicationContext.getBean(
            RestaurantRepository.class
        );
        return restaurantRepository;
    }
}
//>>> DDD / Aggregate Root
