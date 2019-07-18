package com.iweb.springboot1.mapper;
import com.iweb.springboot1.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 接口，我们没有加任何注解，能不能扫到？
 */
@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();
}
