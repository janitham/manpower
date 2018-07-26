package inc.manpower.service;

import inc.manpower.domain.Employee;

import java.util.List;

public interface RecruitmentService {
    List<Employee> findHuntersRecruitmentForMonth(Long huntersId);
}
