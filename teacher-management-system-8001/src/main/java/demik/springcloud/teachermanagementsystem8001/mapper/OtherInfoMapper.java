package demik.springcloud.teachermanagementsystem8001.mapper;

import demik.springcloud.entity.domain.po.BookPO;
import demik.springcloud.entity.domain.vo.DeptVO;
import demik.springcloud.entity.domain.vo.EducationBackgroudVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 1:28 AM
 * @since JDK 1.8
 */
@Mapper
public interface OtherInfoMapper {
    /**
     * 查询所有的教育背景
     * @return
     */
    @Select("SELECT education_backgroud_id,education_backgroud_name from education_backgroud;")
    List<EducationBackgroudVO> findAllEducationBackgroud();

    /**
     * 查询所有的职称
     * @return
     */
    @Select("SELECT dept_id,dept_name from dept_info;")
    List<DeptVO> findAllDept();

    /**
     * 查询所有的教材
     * @return
     */
    @Select("select book_id,book_name from book_info")
    List<BookPO> findAllBook();
}