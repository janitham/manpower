package inc.manpower.repository;

import inc.manpower.domain.RecruitmentOverview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruitmentOverviewRepository extends CrudRepository<RecruitmentOverview, String> {
    List<RecruitmentOverview> findByHunterId(Long hunterId);
}
