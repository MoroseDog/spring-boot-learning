package com.jj.learning.springboot.chapter14.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // 使用自動化命名規則進行條件搜尋
    Customer findByName(String name);

    // 使用自動化命名規則進行條件搜尋(多條件)
    List<Customer> findByNameAndAge(String name, Integer age);

    // 自定義SQL查詢
    @Query(value = "select * from customer where name = ?1", nativeQuery = true)
    Customer queryByName(String name);

}
