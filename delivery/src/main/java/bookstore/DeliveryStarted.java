package bookstore;


public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private String address;
    private Long orderId;

    public DeliveryStarted(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = address;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long OrderId) {
        this.orderId = orderId;
    }
}
