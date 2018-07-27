package inc.manpower.repository;

import inc.manpower.domain.HeadHunter;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface HeadHunterRepository extends PagingAndSortingRepository<HeadHunter, Long> {
}
