package inc.manpower.service;

import inc.manpower.domain.HeadHunter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HeadHuntersService {
    Page<HeadHunter> findAllPageable(Pageable pageable);
}
