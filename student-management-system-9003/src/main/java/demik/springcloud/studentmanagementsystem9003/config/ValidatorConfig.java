package demik.springcloud.studentmanagementsystem9003.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Function: 校验方法参数的配置文件
 *
 * @author miluo
 * Date: 2018/9/9 下午2:35
 * @since JDK 1.8
 */
@Configuration
public class ValidatorConfig {

    /**
     * 配置方法参数校验 快速失败返回模式（只要有一个校验失败就立刻返回）
     *
     * @return 校验方法类
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        // 设置validator模式为快速失败返回
        postProcessor.setValidator(validator());
        return postProcessor;

    }


    /**
     * 配置Bean 快速失败返回模式（只要有一个校验失败就立刻返回）
     *
     * @return 校验对象
     */
    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                // true：快速失败返回模式 false：普通模式
                .failFast(true)
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }
}
