package com.jj.learning.springboot.chapter41.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer userId;
    @NotEmpty
    private String userName;
    @NotEmpty
    private String passWord;

    // 多對多關係
    @ManyToMany(fetch = FetchType.EAGER)
    // 急加載，加載一個實體時，定義急加載的屬性會立即從數據庫中加載
    // FetchType.LAZY：懶加載，加載一個實體時，定義懶加載的屬性不會馬上從數據庫中加載
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "userId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> roleList;// 一個用戶具有多個角色

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

}