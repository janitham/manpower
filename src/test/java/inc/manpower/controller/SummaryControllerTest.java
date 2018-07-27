package inc.manpower.controller;

import inc.manpower.domain.HuntersSummary;
import inc.manpower.service.PaymentsService;
import inc.manpower.service.RecruitmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SummaryController.class)
public class SummaryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecruitmentService recruitmentService;

    @MockBean
    private PaymentsService paymentsService;

    @Test
    public void summariseHuntersTest() throws Exception {
        final String testString = "myTestingType123";
        List<HuntersSummary> summaries = new ArrayList<>();
        HuntersSummary huntersSummary = new HuntersSummary();
        huntersSummary.setEmType(testString);
        summaries.add(huntersSummary);
        when(recruitmentService.findHuntersRecruitmentForMonth(ArgumentMatchers.any())).thenReturn(summaries);
        this.mockMvc.perform(get("/summary?hunterId=1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(testString)));
    }

    @Test
    public void calculateTest() throws Exception {
        final Double amount = 1000d;
        List<HuntersSummary> summaries = new ArrayList<>();
        when(recruitmentService.findHuntersRecruitmentForMonth(ArgumentMatchers.any())).thenReturn(summaries);
        when(paymentsService.calculatePaymentsForHunterForMonth(ArgumentMatchers.any())).thenReturn(amount);
        this.mockMvc.perform(get("/summary?hunterId=1&calculate=true")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(String.valueOf(amount))));
    }
}