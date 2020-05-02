package book;

import book.model.Book;

import com.github.javafaker.Faker;

import java.time.ZoneId;
import java.util.Locale;

public class BookGenerator {

    private static Faker faker = new Faker (new Locale("en"));

    public static Book randomBook() {
        Book book = Book.builder()
                .isbn13(faker.code().isbn13())
                .author(faker.book().author())
                .title(faker.book().title())
                .format(faker.options().option(Book.Format.class))
                .publisher(faker.book().publisher())
                .publicationDate(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .pages(faker.number().randomDigit())
                .available(faker.bool().bool())
                .build();
        return book;
    }
}
