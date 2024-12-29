package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.User;

@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{username} ")
    User getByUserName(String username);

    @Insert("insert into user(username, password,create_time, update_time) "+
    "values (#{username},#{password},now(),now())")
    void add(String username, String password);

    @Update("update user set nickname=#{nickname},email=#{email},update_time=now() where id=#{id}")
    void update(User user);

    @Update("update user set user_pic=#{url},update_time=now() where id=#{id}")
    void updateAvatar(String url,Integer id);

    @Update("update user set password=#{md5String},update_time=now() where id=#{id}")
    void updatePwd(String md5String,Integer id);
}
