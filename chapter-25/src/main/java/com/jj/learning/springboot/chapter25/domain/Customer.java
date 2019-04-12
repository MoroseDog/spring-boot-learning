package com.jj.learning.springboot.chapter25.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// 宣告為實體(@Entity)
@Entity
// 對應資料庫表名稱
@Table(name="customer")
// 啟用審計(Auditing)的實體中都必須註冊這個 Listener，否則是沒有效果
@EntityListeners(AuditingEntityListener.class)
public class Customer implements Serializable {
    
    @Id
    // 主鍵由數據庫自動維護(AUTO_INCREMENT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "age")
    private Integer age;
    
    @Column(name = "create_by")
    private String createBy;
    
    @Column(name = "create_dt")
    // 自動創建時間
    @CreatedDate()
    private Date createDt;
    
    @Column(name = "modify_by")
    private String modifyBy;
    
    @Column(name = "modify_dt")
    // 修改時自動創建時間
    @LastModifiedDate
    private Date modifyDt;
    
    public Customer(){}
    
    public Customer(String name, Integer age, String createBy){
        this.name = name;
        this.age = age;
        this.createBy = createBy;
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
