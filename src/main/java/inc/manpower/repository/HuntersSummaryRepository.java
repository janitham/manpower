package inc.manpower.repository;

import inc.manpower.domain.HuntersSummary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HuntersSummaryRepository extends CrudRepository<HuntersSummary, String> {
    List<HuntersSummary> findByEmpRecruitedDateBetweenAndHhId(Date startDate, Date endDate, String hhId);
}
