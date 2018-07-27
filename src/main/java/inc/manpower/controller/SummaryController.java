package inc.manpower.controller;

import inc.manpower.domain.Employee;
import inc.manpower.domain.HeadHunter;
import inc.manpower.domain.HuntersSummary;
import inc.manpower.service.HeadHuntersService;
import inc.manpower.service.PaymentsService;
import inc.manpower.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class SummaryController {

    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired
    private PaymentsService paymentsService;

    /**
     * Handles all requests
     *
     * @param pageSize
     * @param page
     * @return model and view
     */
    @GetMapping("/summary")
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page,
                                        @RequestParam("hunterId") Optional<Long> hunterId,
                                        @RequestParam("calculate") Optional<Boolean> calculate
    ) {
        ModelAndView modelAndView = new ModelAndView("summary");

        modelAndView.addObject("hunterId", hunterId.get());

        List<HuntersSummary> summaries = recruitmentService.findHuntersRecruitmentForMonth(hunterId.get());
        modelAndView.addObject("summaries", summaries);

        if (calculate.isPresent() && calculate.get()) {
            Double amount = paymentsService.calculatePaymentsForHunterForMonth(1L);
            modelAndView.addObject("amount", amount);
            modelAndView.addObject("calculate", calculate.get());
        }

        return modelAndView;
    }

}
