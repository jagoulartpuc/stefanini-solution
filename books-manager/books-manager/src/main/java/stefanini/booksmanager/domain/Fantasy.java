package stefanini.booksmanager.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Fantasy {

    private Book book;
    private Movie movie;

}