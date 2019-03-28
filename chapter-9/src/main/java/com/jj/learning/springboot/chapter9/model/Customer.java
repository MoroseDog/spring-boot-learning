package com.jj.learning.springboot.chapter9.model;

import io.swagger.annotations.ApiModelProperty;

public class Customer {

    @ApiModelProperty(value = "ID", name = "id", example = "1")
    private Long id;

    @ApiModelProperty(value = "客戶名稱", name = "name", example = "J.J.Huang")
    private String name;

    @ApiModelProperty(value = "客戶年齡", name = "age", example = "18")
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
