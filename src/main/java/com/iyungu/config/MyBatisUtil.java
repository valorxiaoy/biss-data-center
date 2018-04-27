package com.iyungu.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @Author: yueyang@iyungu.com
 * @Description:
 * @Date: Created in 16:44 2018/4/17
 * @Modified By:
 */
public class MyBatisUtil {
    /*
     * 定义配置文件的位置
     */
    private static final String CONFIG_PATH = "config/mybatis-config.xml";

    /*
     * 获取数据库访问链接
     */
    public static SqlSession getSqlSession() {
        try {
            InputStream stream = Resources.getResourceAsStream(CONFIG_PATH);
            // 可以根据配置的相应环境读取相应的数据库环境
            // SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream, "development");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
            SqlSession session = factory.openSession();
            return session;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * 获取数据库访问链接
     */
    public static void closeSession(SqlSession session) {
        session.close();
    }

}
