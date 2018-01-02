package com.fx.core.utile;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;
 
/*
 * 注册MyBatis分页插件PageHelper
 */
@Slf4j
@Configuration
public class PageHelperConfiguration {
        @Bean
        public PageHelper pageHelper() {
            PageHelper pageHelper = new PageHelper();
            Properties p = new Properties();
            p.setProperty("offsetAsPageNum", "true");
            p.setProperty("rowBoundsWithCount", "true");
            //p.setProperty("reasonable", "true");
            //通过设置pageSize =0或者RowBounds.limit=0就可以查询出全部结果
            //p.setProperty("pageSizeZero","true");
            pageHelper.setProperties(p);
            return pageHelper;
        }
}