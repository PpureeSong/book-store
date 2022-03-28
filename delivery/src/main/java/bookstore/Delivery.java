package bookstore;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;


@Entity
@Table(name="Delivery_table")
public class Delivery  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String address;

    private Long orderId;


    @PostPersist
    public void onPostPersist(){
        Delivered delivered = new Delivered();
        BeanUtils.copyProperties(this, delivered);
        delivered.publishAfterCommit();

        DeliveryStarted deliveryStarted = new DeliveryStarted();
        BeanUtils.copyProperties(this, deliveryStarted);
        deliveryStarted.publishAfterCommit();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    



}
