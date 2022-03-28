package bookstore;


public class Rejected extends AbstractEvent {

    private Long id;

    public Rejected(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = id;
    }
}
