package inc.manpower.service.impl;

import inc.manpower.domain.HeadHunter;
import inc.manpower.domain.HuntersSummary;
import inc.manpower.repository.HeadHunterRepository;
import inc.manpower.repository.HuntersSummaryRepository;
import inc.manpower.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {

    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RecruitmentServiceImpl.class);

    @Autowired
    private HeadHunterRepository headHunterRepository;
    @Autowired
    private HuntersSummaryRepository huntersSummaryRepository;

    @Override
    public List<HuntersSummary> findHuntersRecruitmentForMonth(Long huntersId) {
        HeadHunter headHunter = headHunterRepository.findById(huntersId).get();
        logger.info("Loding Recruitments of Head Hunter Id:" + huntersId);
        Assert.notNull(headHunter, "Could not find the HeadHunter for Id: " + huntersId);
        Date thisMonthFirst = new Date();
        thisMonthFirst.setDate(1);
        return huntersSummaryRepository.findByEmpRecruitedDateBetweenAndHhId(
                thisMonthFirst,
                new Date(),
                String.valueOf(huntersId));
    }
}
