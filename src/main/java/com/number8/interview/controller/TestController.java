package com.number8.interview.controller;

import com.number8.interview.model.Test;
import com.number8.interview.repository.TestRepository;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

  @Autowired
  TestRepository testRepository;

  @GetMapping("/tests")
  public List<Test> getAll() {
    return testRepository.findAll();
  }

  @GetMapping("/tests/{id}")
  public Test getById(@PathVariable(value = "id") Long id) {
    return testRepository.getOne(id);
  }

  @PostMapping("/tests")
  public Test create(@Valid @RequestBody Test test) {
    return testRepository.save(test);
  }

  @PutMapping("/tests/{id}")
  public Test update(@PathVariable(value = "id") Long id, @Valid @RequestBody Test test) throws Exception {
    Optional<Test> result = testRepository.findById(id);
    if (!result.isPresent()) {
      throw new Exception();
    }
    Test savedTest = result.get();
    savedTest.setName(test.getName());
    return testRepository.save(savedTest);
  }
}
