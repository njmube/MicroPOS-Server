package ow.micropos.server.repository.seating;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import ow.micropos.server.model.seating.Section;

@RepositoryRestResource(exported = false)
public interface SectionRepository extends JpaRepository<Section, Long> {

    @Modifying
    @Query(value = "ALTER TABLE section ALTER COLUMN id RESTART WITH 1", nativeQuery = true)
    void resetIds();

}
