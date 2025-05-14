package com.example.demo.bootstrap;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.entities.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
  private BookRepository bookRepository;
  private AuthorRepository authorRepository;
  private PublisherRepository publisherRepository;

  public BootStrapData(
      BookRepository bookRepository,
      AuthorRepository authorRepository,
      PublisherRepository publisherRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author bob = new Author("bob", "ross");
    Book lol = new Book("lol", (long) 1000);
    Publisher pub = new Publisher("wow", "33 rue du Lion");

    bob.getBooks().add(lol);
    lol.getAuthors().add(bob);

    bookRepository.save(lol);
    authorRepository.save(bob);
    publisherRepository.save(pub);

    System.out.println("Finish");
    System.out.println("count" + bookRepository.count());
  }
}
