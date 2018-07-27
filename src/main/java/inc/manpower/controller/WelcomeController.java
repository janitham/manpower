package inc.manpower.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

	@RequestMapping("/welcome")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);

		System.out.println("list all brokers");
		Lists.newArrayList(repository.findAll()).stream().forEach(k-> System.out.println(k.getEmployeesCount()));
		System.out.println("summary");
		/*try {
			huntersSummaryRepository.findAllByEmpRecruitedDateBetween(
					new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2018"),
					new SimpleDateFormat("dd/MM/yyyy").parse("30/07/2018"))
					.forEach(k-> System.out.println(k.getId()));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}*/

		return "welcome";
	}

}