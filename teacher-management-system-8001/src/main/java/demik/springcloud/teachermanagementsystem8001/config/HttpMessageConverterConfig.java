package demik.springcloud.teachermanagementsystem8001.config;


import com.google.gson.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import springfox.documentation.spring.web.json.Json;

import java.lang.reflect.Type;

/**
 * Function:添加Gson支持
 *
 * @author miluo
 * Date: 2018/10/16 下午2:43
 * @since JDK 1.8
 */
@Configuration
public class HttpMessageConverterConfig {

    /**
     * 在这创建生成Gson对象
     *
     * @return
     */
    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(new GsonBuilder()
                //null 也序列化
                //.serializeNulls()
                //时间转化为特定格式 yyyy-MM-dd HH:mm:ss
                //.setDateFormat("yyyy-MM-dd hh:mm:ss")
                //设置 Long 类型自动转换成 String 类型
                //.setLongSerializationPolicy(LongSerializationPolicy.STRING)
                .registerTypeAdapter(Json.class, new SpringfoxJsonToGsonAdapter())
                .create());
        return converter;
    }
}


class SpringfoxJsonToGsonAdapter implements JsonSerializer<Json> {

    @Override
    public JsonElement serialize(Json json, Type type, JsonSerializationContext context) {
        final JsonParser parser = new JsonParser();
        return parser.parse(json.value());
    }
}