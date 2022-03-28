package bookstore;

import javax.persistence.*;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="TopBook_table")
public class TopBook {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long bookid;
        private Long count;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getBookid() {
            return bookid;
        }

        public void setBookid(Long bookid) {
            this.bookid = bookid;
        }
        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }

}