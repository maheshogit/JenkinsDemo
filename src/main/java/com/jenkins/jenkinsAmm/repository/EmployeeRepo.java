package com.jenkins.jenkinsAmm.repository;

import com.jenkins.jenkinsAmm.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Integer> {
}
