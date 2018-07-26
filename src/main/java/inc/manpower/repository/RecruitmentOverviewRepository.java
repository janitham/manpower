package inc.manpower.repository;

import inc.manpower.domain.RecruitmentOverview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitmentOverviewRepository extends CrudRepository<RecruitmentOverview, String> {
}
