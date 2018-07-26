package inc.manpower.repository;

import inc.manpower.domain.HeadHunter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadHunterRepository extends CrudRepository<HeadHunter, Long> {
}
