package stefanini.booksmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stefanini.booksmanager.client.MoviesManagerClient;
import stefanini.booksmanager.domain.Book;
import stefanini.booksmanager.domain.Fantasy;
import stefanini.booksmanager.domain.Movie;
import stefanini.booksmanager.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book insertBook(Book book) {
        return bookRepository.insert(book);
    }

    public List<Book> findAllBooks() {
        return bookRepository.getAll();
    }

    public Book editBook(Book book) {
        bookRepository.editBook(book);
        return book;
    }

    public boolean deleteBook(String title) {
        return bookRepository.deleteBook(title);
    }

    public Book findBookByTitle(String title) {
        return bookRepository.getAll().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .findFirst()
                .orElseThrow();
    }
}