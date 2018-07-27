package inc.manpower.controller;

import inc.manpower.domain.HeadHunter;
import inc.manpower.domain.Pager;
import inc.manpower.domain.Person;
import inc.manpower.service.HeadHuntersService;
import inc.manpower.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private HeadHuntersService headHuntersService;

    /**
     * Handles all requests
     *
     * @param pageSize
     * @param page
     * @return model and view
     */
    @GetMapping("/")
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("home");

        List<HeadHunter> headHunters = headHuntersService.findAll();

        modelAndView.addObject("hunters", headHunters);
        //modelAndView.addObject("selectedPageSize", evalPageSize);
        //modelAndView.addObject("pageSizes", PAGE_SIZES);
        //modelAndView.addObject("pager", pager);
        return modelAndView;
    }

}
