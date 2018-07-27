package inc.manpower.service;

import com.google.common.collect.Lists;
import inc.manpower.domain.EmployeeType;
import inc.manpower.domain.HeadHunter;
import inc.manpower.domain.RecruitmentOverview;
import inc.manpower.repository.EmployeeTypeRepository;
import inc.manpower.repository.HeadHunterRepository;
import inc.manpower.repository.RecruitmentOverviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    @Autowired
    private HeadHunterRepository headHunterRepository;

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    @Autowired
    private RecruitmentOverviewRepository recruitmentOverviewRepository;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Double calculatePaymentsForHunterForMonth(Long huntersId) {
        HeadHunter headHunter = headHunterRepository.findById(huntersId).get();
        Assert.notNull(headHunter, "Could not find the HeadHunter for Id: " + huntersId);

        List<EmployeeType> types = Lists.newArrayList(employeeTypeRepository.findAll());
        List<RecruitmentOverview> overviews = recruitmentOverviewRepository.findByHunterId(huntersId);
        Double payments[] = {0.0};

        overviews.forEach(ov -> {
            EmployeeType selectedType = types.stream().filter(type -> type.getId().equals(ov.getTypeId())).findFirst().get();
            payments[0] = payments[0] + selectedType.getAmount() * (ov.getEmployeesCount() + ov.getGroupsCount() * 0.5);
        });

        return payments[0];
    }
}
