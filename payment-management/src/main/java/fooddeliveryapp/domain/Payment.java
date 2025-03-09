package fooddeliveryapp.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import fooddeliveryapp.PaymentManagementApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Payment_table")
@Data
//<<< DDD / Aggregate Root
public class Payment {

    @Id
    private String paymentId;

    private Money amount;

    private String status;

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentManagementApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }
}
//>>> DDD / Aggregate Root
