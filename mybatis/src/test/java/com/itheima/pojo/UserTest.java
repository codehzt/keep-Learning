package com.itheima.pojo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldStoreAndReturnAllProperties() {
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("secret");
        user.setGender("男");
        user.setAddr("北京");

        assertEquals(Integer.valueOf(1), user.getId());
        assertEquals("zhangsan", user.getUsername());
        assertEquals("secret", user.getPassword());
        assertEquals("男", user.getGender());
        assertEquals("北京", user.getAddr());
    }

    @Test
    public void shouldIncludeAllPropertiesInToString() {
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("secret");
        user.setGender("男");
        user.setAddr("北京");

        assertEquals(
                "User{id=1, username=zhangsan, password=secret, gender=男, addr=北京}",
                user.toString());
    }
}
