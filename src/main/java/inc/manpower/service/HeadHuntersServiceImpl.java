package inc.manpower.service;

import com.google.common.collect.Lists;
import inc.manpower.domain.HeadHunter;
import inc.manpower.repository.HeadHunterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadHuntersServiceImpl implements HeadHuntersService{

    @Autowired
    private HeadHunterRepository repository;

    @Override
    public List<HeadHunter> findAll() {
        return Lists.newArrayList(repository.findAll());
    }
}
