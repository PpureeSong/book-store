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
    @Autowired StoreOrderRepository storeOrderRepository;
    @Autowired MenuRepository menuRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaid_주문목록에추가(@Payload Paid paid){

        if(!paid.validate()) return;

        System.out.println("\n\n##### listener 주문목록에추가 : " + paid.toJson() + "\n\n");

        // REST Request Sample
        // bookstore.external.Order order =
        //    StoreApplication.applicationContext.getBean(bookstore.external.OrderService.class)
        //    .getOrder(/** mapping value needed */);


        

        // Sample Logic //
        // StoreOrder storeOrder = new StoreOrder();
        // storeOrderRepository.save(storeOrder);
        // Menu menu = new Menu();
        // menuRepository.save(menu);

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderPlaced_주문목록에추가(@Payload OrderPlaced orderPlaced){

        if(!orderPlaced.validate()) return;

        System.out.println("\n\n##### listener 주문목록에추가 : " + orderPlaced.toJson() + "\n\n");

        // REST Request Sample
        // bookstore.external.Order order =
        //    StoreApplication.applicationContext.getBean(bookstore.external.OrderService.class)
        //    .getOrder(/** mapping value needed */);


        

        // Sample Logic //
        // StoreOrder storeOrder = new StoreOrder();
        // storeOrderRepository.save(storeOrder);
        // Menu menu = new Menu();
        // menuRepository.save(menu);

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCanceled_주문취소알림(@Payload OrderCanceled orderCanceled){

        if(!orderCanceled.validate()) return;

        System.out.println("\n\n##### listener 주문취소알림 : " + orderCanceled.toJson() + "\n\n");


        

        // Sample Logic //
        // StoreOrder storeOrder = new StoreOrder();
        // storeOrderRepository.save(storeOrder);
        // Menu menu = new Menu();
        // menuRepository.save(menu);

    }


}


