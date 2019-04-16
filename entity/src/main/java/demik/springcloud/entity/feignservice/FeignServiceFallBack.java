package demik.springcloud.entity.feignservice;

import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.dto.LoginDTO;
import demik.springcloud.entity.domain.dto.StudentExcelDTO;
import demik.springcloud.entity.domain.dto.TeacherExcelDTO;
import demik.springcloud.entity.domain.po.UserPO;
import demik.springcloud.entity.domain.vo.UserNameVO;
import org.springframework.stereotype.Component;

import java.util.List;

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
        return ResultGenerator.genFailResult("消费者提供的isNameExists服务降级信息，鉴权服务已经下线");
    }

    @Override
    public Result login(LoginDTO loginDTO) {
        return ResultGenerator.genFailResult("消费者提供的login服务降级信息，鉴权服务已经下线");
    }

    @Override
    public Result checkUserInfo(UserNameVO userNameVO) {
        return ResultGenerator.genFailResult("消费者提供的checkUserInfo服务降级信息，鉴权服务已经下线");
    }

    @Override
    public Result addStudentUser(List<StudentExcelDTO> dtos) {
        return ResultGenerator.genFailResult("消费者提供的addStudentUser服务降级信息，鉴权服务已经下线");
    }

    @Override
    public Result addTeacherUser(List<TeacherExcelDTO> dtos) {
        return ResultGenerator.genFailResult("消费者提供的addTeacherUser服务降级信息，鉴权服务已经下线");
    }
}
