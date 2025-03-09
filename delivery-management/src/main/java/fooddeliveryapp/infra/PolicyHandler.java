package fooddeliveryapp.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fooddeliveryapp.config.kafka.KafkaProcessor;
import fooddeliveryapp.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_UserOrderPlaced(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener UserOrderPlaced : " + orderPlaced + "\n\n"
        );

        // Sample Logic //

        PickUpOrderCommand command = new PickUpOrderCommand();
        //command.setDeliveryId("???");
        //command.setDriver("???");
        //command.setAddress("???");
        Delivery.pickUpOrder(command);
    }
}
//>>> Clean Arch / Inbound Adaptor
