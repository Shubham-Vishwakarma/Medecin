package com.medecin.controllers.api;

import com.medecin.model.Test;
import com.medecin.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @GetMapping({ "" , "/all" })
    public Iterable<Test> getAllTest() {
        return testRepository.findAll();
    }

    @PostMapping({ "", "/all" })
    public void addNewTest(@RequestBody Test test) {
        testRepository.save(test);
    }

}
