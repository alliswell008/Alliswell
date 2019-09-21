package alliswell;

import alliswell.mybatis.dao.UserDao;
import alliswell.mybatis.model.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class SpringbootApplication {

    @RequestMapping("/")
    String test() {
        return "hello spring boot";
    }

    @Bean
    InitializingBean saveData(UserDao userDao){
        return ()->{
            userDao.saveUser(new User("11","1","1", "1", "1", null, null));
            userDao.saveUser(new User("12","2","2", "2", "1", null, null));
            userDao.saveUser(new User("13","3","3", "3", "1", null, null));
            userDao.saveUser(new User("14","4","4", "4", "1", null, null));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
