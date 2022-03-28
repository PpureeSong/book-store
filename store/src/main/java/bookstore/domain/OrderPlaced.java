package bookstore.domain;

import bookstore.infra.AbstractEvent;


public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String bookId;
    private String customerId;
    private String preference;

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    public String getbookId() {
        return bookId;
    }

    public void setbookId(String bookId) {
        this.bookId = bookId;
    }
    public String getcustomerId() {
        return customerId;
    }

    public void setcustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getpreference() {
        return preference;
    }

    public void setpreference(String preference) {
        this.preference = preference;
    }
}
