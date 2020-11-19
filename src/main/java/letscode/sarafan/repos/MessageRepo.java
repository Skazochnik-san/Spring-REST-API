package letscode.sarafan.repos;

import letscode.sarafan.domain.Messages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Messages, Long> {

    Page<Messages> findAll(Pageable pageable);

    Page<Messages> findByTag(String tag, Pageable pageable);
}