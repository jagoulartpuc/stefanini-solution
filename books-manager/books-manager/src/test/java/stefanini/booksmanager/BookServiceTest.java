package stefanini.booksmanager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import stefanini.booksmanager.domain.Book;
import stefanini.booksmanager.repository.BookRepository;
import stefanini.booksmanager.service.BookService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @InjectMocks
    private BookService service;

    @Mock
    private BookRepository repository;

    @Test
    public void bookServiceShouldInsertBook() {
        Book book = Book.builder()
                .title("Harry Potter and the Philosopher's Stone")
                .author("J. K. Rowling")
                .country("United Kingdom")
                .releaseDate("26 June 1997")
                .publisher("Bloomsbury (UK)")
                .build();

        given(repository.insert(book)).willReturn(book);

        service.insertBook(book);
        Assert.assertEquals(service.insertBook(book), repository.insert(book));
    }

    @Test
    public void bookServiceShouldlistBooks() {
        Book book1 = Book.builder().build();
        Book book2 = Book.builder().build();
        Book book3 = Book.builder().build();

        given(repository.getAll()).willReturn(Arrays.asList(book1, book2, book3));

        List<Book> toolsReturned = service.findAllBooks();
        Assert.assertEquals(Arrays.asList(book1, book2, book3), toolsReturned);
    }

    @Test
    public void toolServiceShouldDeleteBook() {
        String title = "Harry Potter and the Philosopher's Stone";

        Book book = Book.builder().title(title).build();
        service.insertBook(book);
        service.deleteBook(title);
        assertTrue(service.findAllBooks().isEmpty());
    }
}
