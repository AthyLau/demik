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

    /**
     * 根据id查询单个教育背景
     * @param id
     * @return
     */
    public EducationBackgroudVO findEducationBackgroudById(Integer id) {
        return otherInfoManager.findEducationBackgroudById(id);
    }

    /**
     * 根据id查询职称
     * @param id
     * @return
     */
    public DeptVO findDeptById(Integer id) {
        return otherInfoManager.findDeptById(id);
    }

    /**
     * 根据id查询教材
     * @param id
     * @return
     */
    public BookPO findBookById(Integer id) {
        return otherInfoManager.findBookById(id);
    }

    /**
     * 根据名字查找教材名字
     * @param name
     * @return
     */
    public BookPO findBookByName(String name) {
        return otherInfoManager.findBookByName(name);
    }

    /**
     * 添加教材
     * @param bookPO
     * @return
     */
    public Boolean addBook(BookPO bookPO) {
        return otherInfoManager.addBook(bookPO);
    }
}
