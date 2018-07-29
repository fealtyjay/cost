package com.hit.cost;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * Druid数据库连接池工具，同时也能够统计和监控数据库的性能，
 * 同时也能进行功能扩展
 *
 * @Date：2018/7/14 15:58
 * <p>
 * Created By IDEA
 * ==========================
 */
@Configuration
public class DruidConfiguration {
    @Bean
    public ServletRegistrationBean startViewServlet(){
        //创建servlet注册实体
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //设置ip白名单
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //设置ip黑名单，如果allow与deny共同存在时,deny优先于allow
//        servletRegistrationBean.addInitParameter("deny","192.168.0.19");
        //设置控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername","druid");
        servletRegistrationBean.addInitParameter("loginPassword","123456");
        //是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean startFilter(){
        //创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    /**
     * 我来统一回答一下没有监控到sql的问题吧，因为配置的Druid相关的属性并不在DataSourceProperties的属性列表里，所以Druid相关的值注入是不成功的；
     两种方式解决：
     1、在你的自动配置类里DruidConfiguration添加以下方法
     @ConfigurationProperties(prefix = "spring.datasource")
     @Bean
     public DataSource druid(){
     return new DruidDataSource();
     }
     2、将Druid的pom坐标替换成starter
     <dependency>
     <groupId>com.alibaba</groupId>
     <artifactId>druid-spring-boot-starter</artifactId>
     <version>1.1.2</version>
     </dependency>
     * @return
     */
   /* @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }*/
}
