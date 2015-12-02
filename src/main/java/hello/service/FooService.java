package hello.service;

import hello.domain.Foo;
import hello.repository.FooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FooService {
    @Autowired
    private FooRepository fooRepository;

    public List<Foo> findAll() {
        return fooRepository.findAll();
    }

    @Transactional
    public void create(String name) {
        fooRepository.findAll();
        // Set breakpoint here to confirm the fail over behaviour during a transaction
        Foo entity = new Foo();
        entity.setName(name);
        fooRepository.save(entity);
    }
}
