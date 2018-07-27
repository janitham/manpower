package inc.manpower.repository;

import inc.manpower.domain.RecruitmentOverview;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RecruitmentOverviewRepository extends PagingAndSortingRepository<RecruitmentOverview, String> {
    List<RecruitmentOverview> findByHunterId(Long hunterId);
}
