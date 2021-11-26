package stefanini.booksmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stefanini.booksmanager.domain.Book;
import stefanini.booksmanager.domain.Movie;
import stefanini.booksmanager.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book postBook(
            @RequestBody Book book
    ) {
        return bookService.insertBook(book);
    }

    @GetMapping
    public List<Book> findBooks(
    ) {
        return bookService.findAllBooks();
    }

    @GetMapping("/search")
    public Book findBookByTitle(
            @RequestParam String title
    ) {
        return bookService.findBookByTitle(title);
    }

    @PutMapping
    public Book editBook(
            @RequestBody Book book
    ) {
        return bookService.editBook(book);
    }

    @DeleteMapping("/{title}")
    public boolean deleteBook(
            @PathVariable String title
    ) {
        return bookService.deleteBook(title);
    }
}
