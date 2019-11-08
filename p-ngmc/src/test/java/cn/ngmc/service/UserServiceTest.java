package cn.ngmc.service;

import cn.ngmc.entity.User;
import junit.extensions.TestSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:spring.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;



    @Test
    public void getUserTest() {
        User user=userService.getUser(1l);
        System.out.println(user.getUserId()+"\t"+user.getUserName());
    }


}
