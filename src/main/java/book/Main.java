package book;

import book.model.Book;
import com.google.inject.Guice;
import com.google.inject.Injector;

import guice.PersistenceModule;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new PersistenceModule("test"));
        BookDao bookDao = injector.getInstance(BookDao.class);
        BookGenerator bookGenerator = injector.getInstance(BookGenerator.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter how many books you want to generate: ");
        int howManyBooks = scanner.nextInt();

        for (int i = 0; i < howManyBooks; i++) {
            Book book = bookGenerator.randomBook();
            bookDao.persist(book);
        }
        bookDao.findAll()
                .stream()
                .forEach(System.out::println);
    }
}


