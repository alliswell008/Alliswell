package org.alliswell.testspringboot.dao;

import org.alliswell.testspringboot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by alliswell on 2017/10/3.
 */
public interface UserDao {
    @Select("select * from t_user_account")
    List<User> findAll();

    @Insert("INSERT INTO `t_user_account` VALUES (#{id}, #{account}, #{passwd}, #{personId}, now(), null);")
    int saveUser(User user);
}
