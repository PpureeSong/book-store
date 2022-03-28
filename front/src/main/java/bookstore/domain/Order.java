package bookstore.domain;

import bookstore.domain.OrderPlaced;
import bookstore.domain.OrderCanceled;
import bookstore.FrontApplication;
import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;


@Entity
@Table(name="Order_table")
public class Order  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    private Long id;
    
    
    private String bookId;
    
    
    private String customerId;
    
    
    private String preference;
    
    
    private String options;
    
    
    private Address address;

    @PostPersist
    public void onPostPersist(){
        OrderPlaced orderPlaced = new OrderPlaced();
        BeanUtils.copyProperties(this, orderPlaced);
        orderPlaced.publishAfterCommit();

    }
    @PostRemove
    public void onPostRemove(){
        OrderCanceled orderCanceled = new OrderCanceled();
        BeanUtils.copyProperties(this, orderCanceled);
        orderCanceled.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){
    }
    @PreRemove
    public void onPreRemove(){
        // Get request from StoreOrder
        //bookstore.external.StoreOrder storeOrder =
        //    Application.applicationContext.getBean(bookstore.external.StoreOrderService.class)
        //    .getStoreOrder(/** mapping value needed */);

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
    
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    
    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
    
    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
    
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    


    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }


    public static void handle(Rejected rejected){
        Order order = new Order();
        /*
        LOGIC GOES HERE
        */
        repository().save(order);

    }
    public static void handle(OrderCanceled orderCanceled){
        Order order = new Order();
        /*
        LOGIC GOES HERE
        */
        repository().save(order);

    }


}
