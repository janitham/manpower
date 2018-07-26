package inc.manpower.repository;

import inc.manpower.domain.EmployeeType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTypeRepository extends CrudRepository<EmployeeType, Integer> {
}
