package letscode.sarafan.repos;

import letscode.sarafan.domain.Messages;
import letscode.sarafan.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MessageRepo extends CrudRepository<Messages, Long> {

    Page<Messages> findAll(Pageable pageable);

    Page<Messages> findByTag(String tag, Pageable pageable);

    @Query("from Messages m where m.author = :author")
    Page<Messages> findByUser(Pageable pageable, @Param("author") User author);
}