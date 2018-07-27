package inc.manpower.repository;

import inc.manpower.domain.EmployeeType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EmployeeTypeRepository extends PagingAndSortingRepository<EmployeeType, Long> {
}
