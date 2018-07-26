package inc.manpower.repository;

import inc.manpower.domain.HuntersSummary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuntersSummaryRepository extends CrudRepository<HuntersSummary, String> {
}
