package soraia.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import soraia.springframework.spring5webapp.model.Author;
import soraia.springframework.spring5webapp.model.Book;
import soraia.springframework.spring5webapp.model.Publisher;
import soraia.springframework.spring5webapp.repositories.AuthorRepository;
import soraia.springframework.spring5webapp.repositories.BookRepository;
import soraia.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;
  private PublisherRepository publisherRepository;

  public DevBootstrap(
      AuthorRepository authorRepository,
      BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }

  private void initData() {
    Publisher harper = new Publisher("Harper Collins", "Address 1");
    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "1234", harper);
    ddd.getAuthors().add(eric);

    publisherRepository.save(harper);
    authorRepository.save(eric);
    bookRepository.save(ddd);


    Publisher worx = new Publisher("Worx", "Address 2");
    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
    rod.getBooks().add(noEJB);

    publisherRepository.save(worx);
    authorRepository.save(rod);
    bookRepository.save(noEJB);

  }
}
