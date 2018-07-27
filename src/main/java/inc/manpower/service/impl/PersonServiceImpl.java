package inc.manpower.service.impl;


import inc.manpower.domain.Person;
import inc.manpower.repository.PersonRepository;
import inc.manpower.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Page<Person> findAllPageable(Pageable pageable) {
        return personRepository.findAll(pageable);
    }
}
