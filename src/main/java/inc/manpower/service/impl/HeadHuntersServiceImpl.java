package inc.manpower.service.impl;

import inc.manpower.domain.HeadHunter;
import inc.manpower.repository.HeadHunterRepository;
import inc.manpower.service.HeadHuntersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HeadHuntersServiceImpl implements HeadHuntersService {

    @Autowired
    private HeadHunterRepository repository;

    @Override
    public Page<HeadHunter> findAllPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
