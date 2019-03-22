package com.jj.learning.springboot.chapter12.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Long id;
    private String name;
    private Integer age;

}
