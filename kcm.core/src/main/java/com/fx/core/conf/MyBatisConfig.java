package com.fx.core.conf;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.fx.core.common.DatabaseType;
import com.fx.core.common.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * springboot集成mybatis的基本入口
 * 1）创建数据源(如果采用的是默认的tomcat-jdbc数据源，则不需要)
 * 2）创建SqlSessionFactory
 * 3）配置事务管理器，除非需要使用事务，否则不用配置
 * Created by JONES on 2017/12/29.
 */
@Configuration // 该注解类似于spring配置文件
@MapperScan(basePackages = "com.fx.core.dao.mapper")
public class MyBatisConfig {

    @Value("${spring.datasource.dbSourceFirst.driver_class_name}")
    String driverClassNameFirst;
    @Value("${spring.datasource.dbSourceFirst.url}")
    String urlFirst;
    @Value("${spring.datasource.dbSourceFirst.username}")
    String usernameFirst;
    @Value("${spring.datasource.dbSourceFirst.password}")
    String passwordFirst;

    @Value("${spring.datasource.dbSourceSecond.driver_class_name}")
    String driverClassNameSource;
    @Value("${spring.datasource.dbSourceSecond.url}")
    String urlSource;
    @Value("${spring.datasource.dbSourceSecond.username}")
    String usernameSource;
    @Value("${spring.datasource.dbSourceSecond.password}")
    String passwordSource;

    @Value("${mybatis.typeAliasesPackage}")
    String mybatisTypeAliasesPackage;
    @Value("${mybatis.mapperLocations}")
    String mybatisMapperLocations;

    /**
     * 创建数据源(数据源的名称：方法名可以取为XXXDataSource(),XXX为数据库名称,该名称也就是数据源的名称)
     */
    @Bean
    public DataSource myDbDataSourceFirst() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", driverClassNameFirst);
        props.put("url", urlFirst);
        props.put("username", usernameFirst);
        props.put("password", passwordFirst);
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean
    public DataSource myDbDataSourceSecond() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", driverClassNameSource);
        props.put("url", urlSource);
        props.put("username", usernameSource);
        props.put("password", passwordSource);
        return DruidDataSourceFactory.createDataSource(props);
    }

    /**
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     */
    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("myDbDataSourceFirst") DataSource myDbDataSourceFirst,
                                        @Qualifier("myDbDataSourceSecond") DataSource myDbDataSourceSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DatabaseType.dbSourceFirst, myDbDataSourceFirst);
        targetDataSources.put(DatabaseType.dbSourceSecond, myDbDataSourceSource);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(myDbDataSourceSource);// 默认的datasource设置为myTestDbDataSource

        return dataSource;
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    /*@Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource ds) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);// 指定数据源(这个必须有，否则报错)
        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        String typeAliasesPackage = "com.frame.sys.pojo;"
                + "com.frame.user.pojo;"
                + "com.frame.dep.pojo;"
                + "com.bps.crm.pojo";
        fb.setTypeAliasesPackage(mybatisTypeAliasesPackage);// 指定基包
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mybatisMapperLocations));//

        return fb.getObject();
    }*/
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("myDbDataSourceFirst") DataSource myDbDataSourceFirst,
                                               @Qualifier("myDbDataSourceSecond") DataSource myDbDataSourcemySecond) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(this.dataSource(myDbDataSourceFirst, myDbDataSourcemySecond));
        fb.setTypeAliasesPackage(mybatisTypeAliasesPackage);
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mybatisMapperLocations));
        return fb.getObject();
    }

    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
}
