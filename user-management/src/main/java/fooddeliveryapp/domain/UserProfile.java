package fooddeliveryapp.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import fooddeliveryapp.UserManagementApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "UserProfile_table")
@Data
//<<< DDD / Aggregate Root
public class UserProfile {

    @Id
    private String userId;

    private String name;

    private Email email;

    private Password password;

    public static UserProfileRepository repository() {
        UserProfileRepository userProfileRepository = UserManagementApplication.applicationContext.getBean(
            UserProfileRepository.class
        );
        return userProfileRepository;
    }
}
//>>> DDD / Aggregate Root
