package demik.springcloud.singlesignon80.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

/**
 * Function: 如果是需要支持http和https，则启动下列代码，否则，只要在application.properties中配置即可
 * 从今开始，将去掉对http的支持，因此此配置文件将不再生效
 * @author miluo
 * Date: 2018/9/6 下午5:49
 * @since JDK 1.8
 */
//@Configuration
public class HttpsProtocolConfig {
    /**
     * 配置Http使其自动重定向到Https(如果需要同时支持https 和http 此方法去掉)
     *
     * @return Connector类
     */
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
        return tomcat;
    }

    private Connector createStandardConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(8080);
        return connector;
    }


}
