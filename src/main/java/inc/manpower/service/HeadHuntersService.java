package inc.manpower.service;

import inc.manpower.domain.HeadHunter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HeadHuntersService {
    List<HeadHunter> findAll();
    Page<HeadHunter> findAllPageable(Pageable pageable);
}
