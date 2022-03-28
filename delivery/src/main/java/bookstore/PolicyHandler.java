package bookstore;

import bookstore.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryReady_Delivery목록에추가(@Payload DeliveryReady deliveryReady){

        if(!deliveryReady.validate()) return;

        System.out.println("\n\n##### listener Delivery목록에추가 : " + deliveryReady.toJson() + "\n\n");

        // REST Request Sample
        // bookstore.external.Order order =
        //    DeliveryApplication.applicationContext.getBean(bookstore.external.OrderService.class)
        //    .getOrder(/** mapping value needed */);


        

        // Sample Logic //
        // Delivery delivery = new Delivery();
        // deliveryRepository.save(delivery);

    }


}


