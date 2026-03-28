package sheridan.runze.assignment3.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class DatabaseInitializer {

    private final BookRepository bookRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public DatabaseInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void loadData() {
        try (InputStream inputStream = new ClassPathResource("library.json").getInputStream()) {
            BookData bookData = objectMapper.readValue(inputStream, BookData.class);

            if (bookData.getBooks() != null) {
                bookRepository.saveAll(bookData.getBooks());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load library data.", e);
        }
    }
}