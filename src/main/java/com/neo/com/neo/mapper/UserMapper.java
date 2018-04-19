package com.neo.com.neo.mapper;

import com.neo.com.neo.entity.UserEntity;
import com.neo.com.neo.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from users")
    @Results({
            @Result(property = "nickName",column = "nick_name"),
            @Result(property = "userSex",column = "user_sex",javaType = UserSexEnum.class)
    })
    List<UserEntity> getAll();


    @Select("select * from users where id = #{id}")
    @Results({
            @Result(property = "nickName",column = "nick_name"),
            @Result(property = "userSex",column = "user_sex",javaType = UserSexEnum.class)
    })
    UserEntity getOne(Long id);

    @Insert("insert into users(userName,passWord,nick_name,user_sex) values(#{userName}),#{passWord},#{nickName},#{userSex}")
    void insert(UserEntity user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);
}
