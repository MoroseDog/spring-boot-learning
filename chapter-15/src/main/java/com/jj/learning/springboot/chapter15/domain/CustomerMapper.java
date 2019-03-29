package com.jj.learning.springboot.chapter15.domain;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerMapper {

    /**
     * 搜尋客戶
     * 2019年3月29日
     * @param name
     * @return
     *
     */
    @Select("select * from customer where name = #{name}")
    Customer findByName(@Param("name") String name);

    /**
     * 新增客戶
     * 2019年3月29日
     * @param name
     * @param age
     * @param createBy
     * @return
     *
     */
    @Insert("insert into customer(name, age, create_by, create_dt) values(#{name}, #{age}, #{createBy}, now())")
    int insert(@Param("name") String name, @Param("age") Integer age, @Param("createBy") String createBy);
}
