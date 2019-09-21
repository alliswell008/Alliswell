package alliswell.mybatis.controller;

import alliswell.mybatis.dao.shop.ShopUserDao;
import alliswell.mybatis.model.User;
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
public class TestSpringBootController {

    @Autowired
    private alliswell.mybatis.dao.shop.ShopUserDao shopUserDao;

    @Autowired
    private alliswell.mybatis.dao.mall.MallUserDao mallUserDao;

    @RequestMapping("getShopUser")
    public Map<String, Object> getShopUser() {
        List<User> countries = shopUserDao.findAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("List", countries);
        return map;
    }

    @RequestMapping("getMallUser")
    public Map<String, Object> getMallUser() {
        List<User> countries = mallUserDao.findAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("List", countries);
        return map;
    }


}