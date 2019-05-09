package com.jj.learning.springboot.chapter44.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jj.learning.springboot.chapter44.entity.User;

public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);

}
