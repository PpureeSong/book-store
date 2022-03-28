package bookstore;

import bookstore.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class TopBookViewHandler {


    @Autowired
    private TopBookRepository topBookRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            TopBook topBook = new TopBook();
            // view 객체에 이벤트의 Value 를 set 함
            topBook.setFooid(orderPlaced.getFoodId());
            topBook.setCount(0);
            // view 레파지 토리에 save
            topBookRepository.save(topBook);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_UPDATE_1(@Payload OrderPlaced orderPlaced) {
        try {
            if (!orderPlaced.validate()) return;
                // view 객체 조회

                    List<TopBook> topBookList = topBookRepository.findByFooid(orderPlaced.getFoodId());
                    for(TopBook topBook : topBookList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    topBook.setCount(topBook.getCount() +  1);
                // view 레파지 토리에 save
                topBookRepository.save(topBook);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

