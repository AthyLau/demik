package demik.springcloud.entity.feignservice;

import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.dto.LoginDTO;
import demik.springcloud.entity.domain.dto.StudentExcelDTO;
import demik.springcloud.entity.domain.dto.TeacherExcelDTO;
import demik.springcloud.entity.domain.dto.UserDTO;
import demik.springcloud.entity.domain.po.UserPO;
import demik.springcloud.entity.domain.vo.UserNameVO;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Function:自己系统内部想访问鉴权服务内不带token的接口从feign调用
 *
 * @author liubing
 * Date: 2019/3/27 3:38 PM
 * @since JDK 1.8
 */
@FeignClient(name = "single-sign-on",url = "http://127.0.0.1:8081",fallback = FeignServiceFallBack.class)//这个接口出现了问题都去找DeptServiceFallBack这个类
public interface FeignService {
    /**
     *
     * @param userNameVO
     * @return
     */
    @PostMapping("/user/server_in/is_name_exisit")
    Result isNameExists(@RequestBody UserNameVO userNameVO);
    /**
     * 登陆校验
     *
     * @return
     */
    @PostMapping("/user/server_in/login")
    Result login(@RequestBody LoginDTO loginDTO);

    /**
     * 校验用户并根据用户名获取用户信息
     * @param userNameVO
     * @return
     */
    @PostMapping("/user/server_in/check_user_info")
    Result<UserDTO> checkUserInfo(@RequestBody UserNameVO userNameVO);

    /**
     * excel批量添加学生用户
     * @param dtos
     * @return
     */
    @PostMapping("/user/server_in/add_student_user")
    Result addStudentUser(@RequestBody List<StudentExcelDTO> dtos);
    /**
     * excel批量添加教师用户
     * @param dtos
     * @return
     */
    @PostMapping("/user/server_in/add_teacher_user")
    Result addTeacherUser(@RequestBody List<TeacherExcelDTO> dtos);
}
