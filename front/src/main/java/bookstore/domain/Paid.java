package bookstore.domain;

import bookstore.domain.*;
import bookstore.infra.AbstractEvent;


public class Paid extends AbstractEvent {

    private Long id;
    private Long orderId;

    public Paid(){
        super();
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
}
