package com.study.jpa.repository;

import com.study.jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerByExampleRepository extends JpaRepository<Customer, String> {
}
