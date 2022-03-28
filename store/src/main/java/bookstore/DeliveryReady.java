package bookstore;


public class DeliveryReady extends AbstractEvent {

    private Long id;
    private String bookId;
    private String preference;
    private Long orderId;
    private String status;

    public DeliveryReady(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = id;
    }
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String BookId) {
        this.bookId = bookId;
    }
    public String getPreference() {
        return preference;
    }

    public void setPreference(String Preference) {
        this.preference = preference;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long OrderId) {
        this.orderId = orderId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = status;
    }
}
