package com.number8.interview.repository;

import com.number8.interview.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}
