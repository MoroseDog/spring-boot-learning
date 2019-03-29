package com.jj.learning.springboot.chapter15.domain;

import java.util.Date;

public class Customer {
    
    private Long id;
    
    private String name;
    
    private Integer age;
    
    private String create_By;
    
    private Date create_Dt;
    
    private String modify_By;
    
    private Date modify_Dt;
    
    public Customer(){}
    
    public Customer(String name, Integer age, String createBy){
        this.name = name;
        this.age = age;
        this.create_By = createBy;
    }
    
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

    public String getCreate_By() {
        return create_By;
    }

    public void setCreate_By(String create_By) {
        this.create_By = create_By;
    }

    public Date getCreate_Dt() {
        return create_Dt;
    }

    public void setCreate_Dt(Date create_Dt) {
        this.create_Dt = create_Dt;
    }

    public String getModify_By() {
        return modify_By;
    }

    public void setModify_By(String modify_By) {
        this.modify_By = modify_By;
    }

    public Date getModify_Dt() {
        return modify_Dt;
    }

    public void setModify_Dt(Date modify_Dt) {
        this.modify_Dt = modify_Dt;
    }

}
