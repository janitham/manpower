package inc.manpower.service;

import com.google.common.collect.Lists;
import inc.manpower.domain.Employee;
import inc.manpower.domain.HeadHunter;
import inc.manpower.repository.EmployeeRepository;
import inc.manpower.repository.HeadHunterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private HeadHunterRepository headHunterRepository;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public List<Employee> findHuntersRecruitmentForMonth(Long huntersId) {
        HeadHunter headHunter = headHunterRepository.findOne(huntersId);
        Assert.notNull(headHunter, "Could not find the HeadHunter for Id: " + huntersId);
        return Lists.newArrayList(repository.findByHeadHunter(huntersId));
    }
}
