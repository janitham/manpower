package inc.manpower.service;

import inc.manpower.domain.HeadHunter;
import inc.manpower.domain.HuntersSummary;
import inc.manpower.repository.HeadHunterRepository;
import inc.manpower.repository.HuntersSummaryRepository;
import inc.manpower.service.impl.RecruitmentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class RecruitmentServiceTest {

    @MockBean
    private HeadHunterRepository headHunterRepository;

    @MockBean
    private HuntersSummaryRepository huntersSummaryRepository;

    @Autowired
    private RecruitmentService recruitmentService;

    @Test
    public void findHuntersRecruitmentForMonthTest() {

        List<HuntersSummary> summaries = new ArrayList<>();
        HuntersSummary summary = new HuntersSummary();
        summary.setEmpId(1L);
        summaries.add(summary);

        when(headHunterRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(new HeadHunter()));
        when(huntersSummaryRepository.
                findByEmpRecruitedDateBetweenAndHhId(
                        Mockito.any(Date.class), Mockito.any(Date.class), Mockito.any(String.class))).thenReturn(summaries);

        List<HuntersSummary> summariesGot = recruitmentService.findHuntersRecruitmentForMonth(1L);

        assertThat(summaries.get(0).getEmpId()).isEqualTo(summariesGot.get(0).getEmpId());
    }

    @TestConfiguration
    static class RecruitmentServiceTestContextConfiguration {

        @Bean
        public RecruitmentService employeeService() {
            return new RecruitmentServiceImpl();
        }
    }
}
