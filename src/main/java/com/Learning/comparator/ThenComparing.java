package com.Learning.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// This contains both Comparing and thenCompaing methods.

public class ThenComparing {

    public static void main(String... args) {
        System.out.println("-- without thenComparing --");
        withoutThenComparing();
        System.out.println("-- with thenComparing --");
        withThenComparing();
    }

    private static void withoutThenComparing() {
        List<Book> list = createExampleBooks();
        System.out.printf("before sort: %s%n", list);
        Collections.sort(list, Comparator.comparing(Book::getAuthor));
        System.out.printf("after sort: %s%n", list);
    }

    private static void withThenComparing() {
        List<Book> list = createExampleBooks();
        System.out.printf("before sort: %s%n", list);
        Collections.sort(list, Comparator.comparing(Book::getAuthor)
                .thenComparing(Comparator.comparing(Book::getName)));
        System.out.printf("after sort: %s%n", list);
    }

    private static List<Book> createExampleBooks() {
        return Arrays.asList(
                new Book("Sara", "book1"),
                new Book("Sara", "book3"),
                new Book("Sara", "book2"),
                new Book("John", "book5"),
                new Book("John", "book4")
        );
    }

    private static class Book {
        private String author;
        private String name;

        public Book(String author, String name) {
            this.author = author;
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return author + " - " + name;
        }
    }
}
