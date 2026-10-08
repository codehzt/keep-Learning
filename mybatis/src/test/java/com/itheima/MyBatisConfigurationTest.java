package com.itheima;

import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MyBatisConfigurationTest {

    @Test
    public void shouldLoadUserMapperConfiguration() throws IOException {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            assertNotNull(sqlSessionFactory);
            assertTrue(sqlSessionFactory.getConfiguration().hasMapper(UserMapper.class));
            assertTrue(sqlSessionFactory.getConfiguration()
                    .hasStatement("com.itheima.mapper.UserMapper.selectAll"));
        }
    }
}
