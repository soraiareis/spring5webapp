package soraia.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import soraia.springframework.spring5webapp.model.Book;
import soraia.springframework.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
