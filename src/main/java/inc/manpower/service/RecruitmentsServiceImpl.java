package inc.manpower.service;

import inc.manpower.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitmentsServiceImpl implements RecruitmentService{
    @Override
    public List<Employee> findHuntersRecruitmentsForMonth(Long huntersId) {
        return null;
    }
}
