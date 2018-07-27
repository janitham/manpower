package inc.manpower.service;

import inc.manpower.domain.HuntersSummary;

import java.util.List;

public interface RecruitmentService {
    List<HuntersSummary> findHuntersRecruitmentForMonth(Long huntersId);
}
