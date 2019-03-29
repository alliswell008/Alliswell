package org.alliswell.testspringboot.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.alliswell.testspringboot.annotation.TestAnnotation;
import org.alliswell.testspringboot.dao.UserDao;
import org.alliswell.testspringboot.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alliswell on 2017/9/13.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/testboot")
//@MapperScan("org.alliswell.testspringboot.dao")
@TestAnnotation(name = "cba")
public class TestSpringBootController {

    @Autowired
    private UserDao userDao;

    @TestAnnotation(name="abc")
    @RequestMapping("getUser")
    public User getUser(@TestAnnotation(name="args") String n,@TestAnnotation(name="args") String m) {
        User user = new User();
        user.setName("test");
        return user;
    }

    @RequestMapping("getUserById")
    public User getUserById() {
        return userDao.getUserById("id = '1'");
    }

    @RequestMapping("getuser2")
//    public Map<String, Object> getUser2(int pageNum, int pageSize) {
    public Map<String, Object> getUser2(int pageNum, int pageSize) {
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<User> countries = userDao.findAll();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Total", page.getTotal());
        map.put("List", countries);
        System.out.println(new Gson().toJson(countries));
//        Gson gson = new GsonBuilder().setVersion(1.1).serializeNulls().setPrettyPrinting().create();
        Gson gson = new GsonBuilder().serializeNulls().create();
        System.out.println(gson.toJson(countries));
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