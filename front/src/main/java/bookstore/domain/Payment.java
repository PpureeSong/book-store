package bookstore.domain;

import bookstore.domain.Paid;
import bookstore.FrontApplication;
import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;


@Entity
@Table(name="Payment_table")
public class Payment  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    private Long id;
    
    
    private Long orderId;

    @PostPersist
    public void onPostPersist(){
        Paid paid = new Paid();
        BeanUtils.copyProperties(this, paid);
        paid.publishAfterCommit();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    


    public static PaymentRepository repository(){
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(PaymentRepository.class);
        return paymentRepository;
    }


    public static void handle(Rejected rejected){
        Payment payment = new Payment();
        /*
        LOGIC GOES HERE
        */
        repository().save(payment);

    }
    public static void handle(OrderCanceled orderCanceled){
        Payment payment = new Payment();
        /*
        LOGIC GOES HERE
        */
        repository().save(payment);

    }


}
