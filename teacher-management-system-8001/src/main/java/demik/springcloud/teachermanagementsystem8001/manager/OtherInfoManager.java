package demik.springcloud.teachermanagementsystem8001.manager;

import demik.springcloud.entity.domain.po.BookPO;
import demik.springcloud.entity.domain.vo.DeptVO;
import demik.springcloud.entity.domain.vo.EducationBackgroudVO;
import demik.springcloud.teachermanagementsystem8001.mapper.OtherInfoMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 1:28 AM
 * @since JDK 1.8
 */
@Repository
public class OtherInfoManager {

    @Autowired
    private OtherInfoMapper otherInfoMapper;
    /**
     * 查询所有的教育背景
     * @return
     */
    public List<EducationBackgroudVO> findAllEducationBackgroud() {
        return otherInfoMapper.findAllEducationBackgroud();
    }

    /**
     * 查询所有的职称
     * @return
     */
    public List<DeptVO> findAllDept() {
        return otherInfoMapper.findAllDept();
    }

    /**
     * 查询所有的教材
     * @return
     */
    public List<BookPO> findAllBook() {
        return otherInfoMapper.findAllBook();
    }

    /**
     * 根据id查询单个教育背景
     * @param id
     * @return
     */
    public EducationBackgroudVO findEducationBackgroudById(Integer id) {
        return otherInfoMapper.findEducationBackgroudById(id);
    }

    /**
     * 根据id查询职称
     * @param id
     * @return
     */
    public DeptVO findDeptById(Integer id) {
        return otherInfoMapper.findDeptById(id);
    }

    /**
     * 根据id查询教材
     * @param id
     * @return
     */
    public BookPO findBookById(Integer id) {
        return otherInfoMapper.findBookById(id);
    }

    /**
     * 根据名字查找教材名字
     * @param name
     * @return
     */
    public BookPO findBookByName(String name) {
        return otherInfoMapper.findBookByName(name);
    }

    /**
     * 添加教材
     * @param bookPO
     * @return
     */
    public Boolean addBook(BookPO bookPO) {
        return otherInfoMapper.addBook(bookPO);
    }
}
