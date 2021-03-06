package stefanini.booksmanager.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movie {

    private String title;
    private String author;
    private String country;
    private String releaseDate;
    private String cinematography;
    private String type;

}
