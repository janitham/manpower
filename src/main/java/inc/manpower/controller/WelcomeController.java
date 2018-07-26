package inc.manpower.controller;

import java.util.Map;

import com.google.common.collect.Lists;
import inc.manpower.repository.HuntersSummaryRepository;
import inc.manpower.repository.RecruitmentOverviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@Autowired
	private RecruitmentOverviewRepository repository;

	@Autowired
	private HuntersSummaryRepository huntersSummaryRepository;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);

		Lists.newArrayList(repository.findAll()).stream().forEach(k-> System.out.println(k.getEmployees_count()));

		Lists.newArrayList(huntersSummaryRepository.findAll()).forEach(k-> System.out.println(k.getId()));

		return "welcome";
	}

}