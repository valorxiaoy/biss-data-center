package com.iyungu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * @Author: yueyang@iyungu.com
 * @Description: 自定义数据源工厂
 * @Date: Created in 9:29 2018/4/18
 * @Modified By:
 */
public class MyselfDefineDataSourceFactory extends UnpooledDataSourceFactory {

    public MyselfDefineDataSourceFactory() {
        this.dataSource = new DruidDataSource();
    }
}
