package com.jj.learning.springboot.chapter41.domain;

import org.springframework.data.repository.CrudRepository;

import com.jj.learning.springboot.chapter41.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserName(String username);

}
