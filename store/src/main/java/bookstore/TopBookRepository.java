package bookstore;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopBookRepository extends CrudRepository<TopBook, Long> {

    List<TopBook> findByFooid(Long fooid);

}