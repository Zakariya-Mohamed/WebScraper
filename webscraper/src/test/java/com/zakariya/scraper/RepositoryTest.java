package com.zakariya.scraper;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class RepositoryTest {

    private Repository repository;

    @BeforeEach
    void setup() {
        repository = new Repository();
    }

    private ScrapedData createTestData(String url) {
        return new ScrapedData("Test Title", "TT", url, LocalDateTime.now());
    }

    @Test
    void shouldSaveDataToStorage() {
        // 1. Arrange
        ScrapedData data = createTestData("example.com");

        // 2. Act
        repository.save(data);

        // 3. Assert
        assertEquals(1, repository.count(), "Storage count should be 1 after saving");
        assertEquals(data, repository.findById("example.com"), "Should find the exact object saved");
    }

    @Test
    void shouldReturnNullWhenUrlNotFound() {
        // Act
        ScrapedData result = repository.findById("non-existent.com");

        // Assert
        assertNull(result, "Should return null if the URL isn't in storage");
    }

}
