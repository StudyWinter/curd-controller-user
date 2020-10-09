package com.example.mapper;

import com.example.model.User;
import lombok.Data;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    //1、添加用户
    @Insert("insert into user (userName,passWord) values (#{userName},#{passWord})")
    void addUser(String userName,String passWord);

    //2、查找用户
    @Select("select * from user where userName = #{userName}")
    User getUser(String userName);

    //3、删除用户
    @Delete("delete from user where userName = #{userName}")
    void delUser(String userName);

    //4、修改用户信息
    @Update("update user set passWord = #{passWord} where userName = #{userName}")
    void updateUser(String userName,String passWord);
}
