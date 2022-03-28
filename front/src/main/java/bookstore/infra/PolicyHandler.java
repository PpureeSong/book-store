package bookstore.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;

import bookstore.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import bookstore.domain.*;


@Service
public class PolicyHandler{
    @Autowired OrderRepository orderRepository;
    @Autowired PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRejected_CancelPayment(@Payload Rejected rejected){

        if(!rejected.validate()) return;
        Rejected event = rejected;
        System.out.println("\n\n##### listener CancelPayment : " + rejected.toJson() + "\n\n");


        

        // Sample Logic //
        Order.handle(event);
        
        Payment.handle(event);
        

        

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCanceled_CancelPayment(@Payload OrderCanceled orderCanceled){

        if(!orderCanceled.validate()) return;
        OrderCanceled event = orderCanceled;
        System.out.println("\n\n##### listener CancelPayment : " + orderCanceled.toJson() + "\n\n");


        

        // Sample Logic //
        Order.handle(event);
        
        Payment.handle(event);
        

        

    }


}


