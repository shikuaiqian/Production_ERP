package com.cskaoyan.mytest;

import com.cskaoyan.dao.UserMapper;
import com.cskaoyan.domain.User;
import com.cskaoyan.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext*.xml")
public class UserTest {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;
    @Test
    public void selectUserTest()
    {
        User user = userMapper.getByUsername("王经理");
        System.out.println(user);
    }

    @Test
    public void selectRoleByusernameTest()
    {
        String role = userMapper.getRoleByusername("王经理");
        System.out.println("********************************************************"+role);
        List<String> perssionByrole = userService.getPerssionByrole(role);
        System.out.println("*******************************************************************"+perssionByrole);
    }
}
