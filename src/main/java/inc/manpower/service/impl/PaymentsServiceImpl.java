package inc.manpower.service.impl;

import com.google.common.collect.Lists;
import inc.manpower.domain.EmployeeType;
import inc.manpower.domain.HeadHunter;
import inc.manpower.domain.RecruitmentOverview;
import inc.manpower.repository.EmployeeTypeRepository;
import inc.manpower.repository.HeadHunterRepository;
import inc.manpower.repository.RecruitmentOverviewRepository;
import inc.manpower.service.PaymentsService;
import inc.manpower.utils.PaymentsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(PaymentsServiceImpl.class);

    @Autowired
    private HeadHunterRepository headHunterRepository;
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;
    @Autowired
    private RecruitmentOverviewRepository recruitmentOverviewRepository;

    @Override
    public Double calculatePaymentsForHunterForMonth(Long huntersId) {
        HeadHunter headHunter = headHunterRepository.findById(huntersId).get();

        Assert.notNull(headHunter, "Could not find the HeadHunter for Id: " + huntersId);
        logger.debug("Loading the information related to HeadHunter Id: " + huntersId);

        List<EmployeeType> types = Lists.newArrayList(employeeTypeRepository.findAll());
        List<RecruitmentOverview> overviews = recruitmentOverviewRepository.findByHunterId(huntersId);
        Double payments[] = {0.0};

        overviews.forEach(ov -> {
            EmployeeType selectedType = types.stream().filter(type -> type.getId().equals(ov.getTypeId())).findFirst().get();
            payments[0] = payments[0] + PaymentsUtils.calculateCommission(selectedType.getAmount(), ov.getGroupsCount(), ov.getEmployeesCount());
        });

        logger.info("Loaded the information related to HeadHunter Id: " + huntersId);

        return payments[0];
    }
}
