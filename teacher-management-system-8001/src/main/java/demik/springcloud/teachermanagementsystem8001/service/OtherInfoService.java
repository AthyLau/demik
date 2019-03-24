package demik.springcloud.teachermanagementsystem8001.service;

import demik.springcloud.entity.domain.po.BookPO;
import demik.springcloud.entity.domain.vo.DeptVO;
import demik.springcloud.entity.domain.vo.EducationBackgroudVO;
import demik.springcloud.teachermanagementsystem8001.manager.OtherInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 1:28 AM
 * @since JDK 1.8
 */
@Service
public class OtherInfoService {
    @Autowired
    private OtherInfoManager otherInfoManager;

    /**
     * 查询所有的教育背景
     * @return
     */
    public List<EducationBackgroudVO> findAllEducationBackgroud() {
        return otherInfoManager.findAllEducationBackgroud();
    }

    /**
     * 查询所有的职称
     * @return
     */
    public List<DeptVO> findAllDept() {
        return otherInfoManager.findAllDept();
    }

    /**
     * 查询所有的教材
     * @return
     */
    public List<BookPO> findAllBook() {
        return otherInfoManager.findAllBook();
    }
}
