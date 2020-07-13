package com.pcq.dao;

import com.pcq.entity.User;
import org.apache.ibatis.annotations.*;



import java.util.List;


public interface UserDao {

    /**
     * 根据id返回用户
     * @param id id
     * @return 返回user对象
     */
    @Select("select * from user where id = #{id}")
    User findUserById(Integer id);

    @Select("select * from user")
    List<User> findAll(int currentPage, int pageSize);

    @Insert("insert user(username,password) values(#{username},#{password})")
    int addUser(User user);


    @Insert("<script>" +
            " insert into user (username,password) values\n" +
            "        <foreach collection=\"list\" item=\"user\" separator=\",\">\n" +
            "            (#{user.username}, #{user.password})\n" +
            "        </foreach>" + "</script>"
    )
    int addUsers(@Param("list")List<User> users);

    @Update("update user set username=#{username},password=#{password} where id = #{id}")
    int updUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUserById(Integer id);
}
