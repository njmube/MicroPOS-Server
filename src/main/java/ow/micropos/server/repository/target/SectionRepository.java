package ow.micropos.server.repository.target;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ow.micropos.server.model.target.Seat;
import ow.micropos.server.model.target.Section;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface SectionRepository extends JpaRepository<Section, Long> {

    @Modifying
    //@Query(value = "ALTER TABLE section ALTER COLUMN id RESTART WITH 1", nativeQuery = true)
    @Query(value = "ALTER TABLE section AUTO_INCREMENT = 1", nativeQuery = true)
    void resetIds();

    List<Section> findByArchived(boolean archived);

}
