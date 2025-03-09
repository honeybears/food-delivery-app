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
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPickedUp'"
    )
    public void wheneverOrderPickedUp_OrderPickedUp(
        @Payload OrderPickedUp orderPickedUp
    ) {
        OrderPickedUp event = orderPickedUp;
        System.out.println(
            "\n\n##### listener OrderPickedUp : " + orderPickedUp + "\n\n"
        );

        // Sample Logic //

        PlaceOrderCommand command = new PlaceOrderCommand();
        //command.setOrderId("???");
        //command.setMenu("???");
        //command.setAddress("???");
        Order.placeOrder(command);
        DeliverOrderCommand command = new DeliverOrderCommand();
        Order.deliverOrder(command);
    }
}
//>>> Clean Arch / Inbound Adaptor
