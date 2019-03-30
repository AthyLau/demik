package demik.springcloud.entity.feignservice;

import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.vo.UserNameVO;
import org.springframework.stereotype.Component;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/27 3:39 PM
 * @since JDK 1.8
 */
@Component
public class FeignServiceFallBack implements FeignService{

    @Override
    public Result isNameExists(UserNameVO userNameVO) {
        return ResultGenerator.genFailResult("消费者提供的服务降级信息，鉴权服务已经下线");
    }
}
