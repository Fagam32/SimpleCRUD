package repo;

import model.Book;
import org.springframework.data.repository.CrudRepository;

public interface bookRepository extends CrudRepository<Book, Integer> {

}
