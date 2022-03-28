package bookstore.domain;

import bookstore.domain.*;
import bookstore.infra.AbstractEvent;


public class OrderCanceled extends AbstractEvent {

    private Long id;
    private String bookId;
    private String customerId;
    private String preference;

    public OrderCanceled(){
        super();
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
}
