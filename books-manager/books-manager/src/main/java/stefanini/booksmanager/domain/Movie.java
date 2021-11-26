package stefanini.booksmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private String title;
    private String author;
    private String country;
    private String releaseDate;
    private String cinematography;
    private String type;

}