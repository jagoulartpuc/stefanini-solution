package stefanini.booksmanager.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {

    private String title;
    private String author;
    private String country;
    private String releaseDate;
    private String publisher;
    private String type;

}
