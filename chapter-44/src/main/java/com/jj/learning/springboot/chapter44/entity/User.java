package com.jj.learning.springboot.chapter44.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private Long id;

    private String username;
    private Integer age;
    
}
