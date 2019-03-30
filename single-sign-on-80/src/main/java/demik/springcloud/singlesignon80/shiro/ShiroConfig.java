package demik.springcloud.singlesignon80.shiro;


import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * Function: shiro 配置项类（插拔式）
 *
 * @author miluo
 * Date: 2018/9/6 下午4:28
 * @since JDK 1.8
 */
@Configuration
public class ShiroConfig {

    @Bean("securityManager")
    public DefaultWebSecurityManager getManager(MyRealm realm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        // 使用自己的realm
        manager.setRealm(realm);

        // 关闭shiro自带的session
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        manager.setSubjectDAO(subjectDAO);

        return manager;
    }

    /**
     * shrio自带过滤器 shiro中过滤器叫 shiroFilter 这里叫factory
     *
     * @param securityManager shiro权限管理中心
     * @return 结果集
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean factory(DefaultWebSecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");

        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        //添加安全控制信息(必须)
        factoryBean.setSecurityManager(securityManager);

        // 添加自己的过滤器并且取名为 jwt
        Map<String, Filter> filterMap = new HashMap<>(1);
        filterMap.put("jwt", new JWTFilter());
        factoryBean.setFilters(filterMap);

        //设置没有找到的页面
        factoryBean.setUnauthorizedUrl("/api/401");

        // 自定义url规则
        Map<String, String> filterChainDefinitionMap = new HashMap<>(12);
        //放行swagger和druid资源
        filterChainDefinitionMap.put("/api/swagger-ui.html","anon");
        filterChainDefinitionMap.put("/api/swagger/**","anon");
        filterChainDefinitionMap.put("/api/webjars/**", "anon");
        filterChainDefinitionMap.put("/api/swagger-resources/**","anon");
        filterChainDefinitionMap.put("/api/v2/**","anon");
        filterChainDefinitionMap.put("/api/druid/**","anon");
        // 访问401和404页面不通过我们的Filter
        filterChainDefinitionMap.put("/401", "anon");
        filterChainDefinitionMap.put("/404", "anon");
        filterChainDefinitionMap.put("/api/401", "anon");
        filterChainDefinitionMap.put("/api/404", "anon");
        //放行静态资源
        filterChainDefinitionMap.put("/static/**", "anon");

        // 所有请求通过我们自己的JWT Filter
        filterChainDefinitionMap.put("/**", "jwt");
        factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("Shiro拦截器工厂类注入成功");
        return factoryBean;
    }

    /**
     * 下面的代码是添加注解支持
     *
     * @return 注解支持，返回值无具体意义
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        // 强制使用cglib，防止重复代理和可能引起代理出错的问题
        // 知乎的这文章写的不错https://zhuanlan.zhihu.com/p/29161098
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
