package stefanini.booksmanager.repository;

import org.springframework.stereotype.Repository;
import stefanini.booksmanager.domain.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public Book insert(Book book) {
        books.add(book);
        return book;
    }

    public List<Book> getAll() {
        return books;
    }

    public Book getBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst()
                .orElseThrow();
    }

    public Book editBook(Book book) {
        Book oldBook = getBookByTitle(book.getTitle());
        return books.set(books.indexOf(oldBook), book);
    }

    public boolean deleteBook(String title) {
        try {
            books.remove(getBookByTitle(title));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
