package inc.manpower.service;

import inc.manpower.domain.HeadHunter;
import inc.manpower.domain.HuntersSummary;
import inc.manpower.repository.EmployeeRepository;
import inc.manpower.repository.HeadHunterRepository;
import inc.manpower.repository.HuntersSummaryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {

    @Autowired
    private HeadHunterRepository headHunterRepository;

    @Autowired
    private HuntersSummaryRepository huntersSummaryRepository;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public List<HuntersSummary> findHuntersRecruitmentForMonth(Long huntersId) {
        HeadHunter headHunter = headHunterRepository.findById(huntersId).get();
        Assert.notNull(headHunter, "Could not find the HeadHunter for Id: " + huntersId);
        Date thisMonthFirst = new Date();
            thisMonthFirst.setDate(1);
            return huntersSummaryRepository.findByEmpRecruitedDateBetweenAndHhId(
                    thisMonthFirst,
                    new Date(),
                    String.valueOf(huntersId));
    }
}
