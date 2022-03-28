package bookstore;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;


@Entity
@Table(name="StoreOrder_table")
public class StoreOrder  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String bookId;

    private String preference;

    private Long orderId;

    private String status;


    @PostPersist
    public void onPostPersist(){
        DeliveryReady deliveryReady = new DeliveryReady();
        BeanUtils.copyProperties(this, deliveryReady);
        deliveryReady.publishAfterCommit();

        Accepted accepted = new Accepted();
        BeanUtils.copyProperties(this, accepted);
        accepted.publishAfterCommit();

        Rejected rejected = new Rejected();
        BeanUtils.copyProperties(this, rejected);
        rejected.publishAfterCommit();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    
    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
    
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    



}
