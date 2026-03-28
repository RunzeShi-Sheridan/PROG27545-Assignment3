package sheridan.runze.assignment3.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BookData {

    private List<Book> books;
}