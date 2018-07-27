package inc.manpower.service;

import inc.manpower.domain.HeadHunter;
import inc.manpower.repository.HeadHunterRepository;
import inc.manpower.service.impl.HeadHuntersServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class HeadHuntersServiceTest {

    @Autowired
    private HeadHuntersService headHuntersService;
    @MockBean
    private HeadHunterRepository repository;

    @Test
    public void findAllPageableTest() {

        Page<HeadHunter> pagePush = new Page<HeadHunter>() {
            @Override
            public int getTotalPages() {
                return 10;
            }

            @Override
            public long getTotalElements() {
                return 0;
            }

            @Override
            public <U> Page<U> map(Function<? super HeadHunter, ? extends U> function) {
                return null;
            }

            @Override
            public int getNumber() {
                return 0;
            }

            @Override
            public int getSize() {
                return 0;
            }

            @Override
            public int getNumberOfElements() {
                return 0;
            }

            @Override
            public List<HeadHunter> getContent() {
                return null;
            }

            @Override
            public boolean hasContent() {
                return false;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public boolean isFirst() {
                return false;
            }

            @Override
            public boolean isLast() {
                return false;
            }

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Pageable nextPageable() {
                return null;
            }

            @Override
            public Pageable previousPageable() {
                return null;
            }

            @Override
            public Iterator<HeadHunter> iterator() {
                return null;
            }
        };

        when(repository.findAll(Mockito.any(Pageable.class))).thenReturn(pagePush);

        Page<HeadHunter> pageGet = headHuntersService.findAllPageable(new Pageable() {
            @Override
            public int getPageNumber() {
                return 10;
            }

            @Override
            public int getPageSize() {
                return 0;
            }

            @Override
            public long getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        });

        assertThat(pagePush.getTotalPages()).isEqualTo(pageGet.getTotalPages());

    }

    @TestConfiguration
    static class HeadHuntersServiceImplTestContextConfiguration {

        @Bean
        public HeadHuntersService employeeService() {
            return new HeadHuntersServiceImpl();
        }
    }


}
