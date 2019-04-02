package com.jj.learning.springboot.chapter19.domain;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

public class Customer {

    @Null(message = "id必須為空")
    private Long id;

    @NotNull(message = "name不可為空")
    @Length(min = 1, max = 10, message = "name長度需為1~10")
    private String name;

    @NotNull(message = "age不可為空")
    @Min(1)
    @Max(100)
    private Integer age;

    @NotNull(message = "createBy不可為空")
    private String createBy;

    @Past
    private Date createDt;

    private String modifyBy;

    @Past
    private Date modifyDt;

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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDt() {
        return modifyDt;
    }

    public void setModifyDt(Date modifyDt) {
        this.modifyDt = modifyDt;
    }

}
