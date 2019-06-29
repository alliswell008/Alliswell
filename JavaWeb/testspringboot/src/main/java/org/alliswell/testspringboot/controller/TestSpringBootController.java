package org.alliswell.testspringboot.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.alliswell.testspringboot.dao.UserDao;
import org.alliswell.testspringboot.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alliswell on 2017/9/13.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/testboot")
@MapperScan("org.alliswell.testspringboot.dao")
public class TestSpringBootController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("getuser")
    public User getUser() {
        User user = new User();
        user.setName("test");
        return user;
    }

    @RequestMapping("getuser2")
    public Map<String, Object> getUser2() {
        Page page = PageHelper.startPage(1, 10);
        List<User> countries = userDao.findAll();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Total", page.getTotal());
        map.put("List", countries);

        return map;
    }

    @RequestMapping("saveuser")
    public User saveUser() {
        User user = new User();
        user.setId("4");
        user.setAccount("test4");
        user.setPasswd("1234");
        user.setPersonId("1");
        user.setName("aa");
        userDao.saveUser(user);

        return user;
    }
}