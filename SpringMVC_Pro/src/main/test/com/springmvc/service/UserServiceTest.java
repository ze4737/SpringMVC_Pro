package com.springmvc.service;

import com.springmvc.entity.dto.User;
import com.springmvc.util.BaseSpringTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ZE on 1/9.
 */
public class UserServiceTest extends BaseSpringTestCase {
    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        System.out.println("==UserServiceTest.setUp==");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("==UserServiceTest.tearDown==");
    }

    @Test
    public void testHasMatchUser() throws Exception {
        boolean b1 = userService.hasMatchUser("admin", "123456");
        assertTrue(b1);
    }

    @Test
    public void testFindUserByUserName() throws Exception {
        User user = userService.findUserByUserName("admin");
        assertEquals(user.getUsername(), "admin");
    }

    @Test
    public void testLoginSuccess() throws Exception {

    }

}