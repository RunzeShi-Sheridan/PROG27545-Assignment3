package sheridan.runze.assignment3.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Book {

    @Id
    private String itemId;

    private String isbn;
    private String bookTitle;
    private int pageCount;

    @JsonProperty("isAvailable")
    private boolean available;

    private double lateFeeUsd;
}