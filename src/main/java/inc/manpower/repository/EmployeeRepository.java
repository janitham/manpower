package inc.manpower.repository;

import inc.manpower.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}
