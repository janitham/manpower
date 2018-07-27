package inc.manpower.repository;

import inc.manpower.domain.HuntersSummary;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface HuntersSummaryRepository extends PagingAndSortingRepository<HuntersSummary, String> {
    List<HuntersSummary> findByEmpRecruitedDateBetweenAndHhId(Date startDate, Date endDate, String hhId);
}
