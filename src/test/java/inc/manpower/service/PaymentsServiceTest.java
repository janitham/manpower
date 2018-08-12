package inc.manpower.service;

import inc.manpower.domain.EmployeeType;
import inc.manpower.domain.HeadHunter;
import inc.manpower.domain.RecruitmentOverview;
import inc.manpower.repository.EmployeeTypeRepository;
import inc.manpower.repository.HeadHunterRepository;
import inc.manpower.repository.RecruitmentOverviewRepository;
import inc.manpower.service.impl.PaymentsServiceImpl;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class PaymentsServiceTest {

    @MockBean
    private HeadHunterRepository headHunterRepository;

    @MockBean
    private EmployeeTypeRepository employeeTypeRepository;

    @MockBean
    private RecruitmentOverviewRepository recruitmentOverviewRepository;

    @Autowired
    private PaymentsService paymentsService;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void calculatePaymentsForHunterForMonthTest() {

        List<EmployeeType> types = new ArrayList<>();
        EmployeeType manson = new EmployeeType();
        manson.setId(1L);
        manson.setAmount(200d);
        types.add(manson);

        List<RecruitmentOverview> overviews = new ArrayList<>();
        RecruitmentOverview overview = new RecruitmentOverview();
        overview.setTypeId(1L);
        overview.setGroupsCount(3L);
        overview.setEmployeesCount(18L);
        overviews.add(overview);

        when(headHunterRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(new HeadHunter()));

        when(employeeTypeRepository.findAll()).thenReturn(types);
        when(recruitmentOverviewRepository.findByHunterId(Mockito.any(Long.class))).thenReturn(overviews);

        Double valueGot = paymentsService.calculatePaymentsForHunterForMonth(1L);

        assertThat(valueGot).isEqualTo(3900);

    }

    @Test
    public void invalidHunterId()
    {
        final long huntersId=0l;

        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Could not find the HeadHunter for Id: " + huntersId);

        when(headHunterRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        paymentsService.calculatePaymentsForHunterForMonth(huntersId);
    }

    @TestConfiguration
    static class HeadHuntersServiceImplTestContextConfiguration {

        @Bean
        public PaymentsService employeeService() {
            return new PaymentsServiceImpl();
        }
    }

}
