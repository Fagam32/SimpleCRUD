package books.example.repos;

import books.example.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepo extends CrudRepository<Book, Long> {
    Iterable<Book> deleteBookByNameStartingWith(String name);
    Iterable<Book> findBookByNameStartingWith(String name);
}
