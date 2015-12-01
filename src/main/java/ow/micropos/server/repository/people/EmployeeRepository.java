package ow.micropos.server.repository.people;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import ow.micropos.server.model.people.Employee;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Modifying
    @Query(value = "ALTER TABLE employee ALTER COLUMN id RESTART WITH 1", nativeQuery = true)
    void resetIds();

    List<Employee> findByArchived(boolean archived);

    List<Employee> findByPin(short pin);

}
