package bookstore;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;


@Entity
@Table(name="Menu_table")
public class Menu  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


    @PostPersist
    public void onPostPersist(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    



}
