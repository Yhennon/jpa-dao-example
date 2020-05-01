package book;

import book.model.Book;
import jpa.GenericJpaDao;

import java.util.Optional;

public class BookDao extends GenericJpaDao {


    Optional<Book> findByIsbn13(String isbn13) {
        return Optional.ofNullable(entityManager.find(Book.class, isbn13));
    }

}
