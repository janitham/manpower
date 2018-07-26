package inc.manpower.service;

import inc.manpower.domain.HeadHunter;
import inc.manpower.repository.HeadHunterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    @Autowired
    private HeadHunterRepository headHunterRepository;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Double calculatePaymentsForHunterForMonth(Long huntersId) {
        HeadHunter headHunter = headHunterRepository.findOne(huntersId);
        Assert.notNull(headHunter, "Could not find the HeadHunter for Id: " + huntersId);



        return null;
    }
}
