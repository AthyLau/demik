package demik.springcloud.studentmanagementsystem9002.mapper;

import demik.springcloud.entity.domain.po.GradeInfoPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 2:37 PM
 * @since JDK 1.8
 */
@Mapper
public interface GradeInfoMapper {

    /**
     * 添加一个
     * @param gradeInfoPO
     * @return
     */
    @Insert("insert into grade_info(grade_name,grade_description,grade_slogan) values(#{gradeName},#{gradeDescription},#{gradeSlogan})")
    boolean addGrade(GradeInfoPO gradeInfoPO);

    /**
     * 删除一个
     * @param id
     * @return
     */
    @Delete("delete from grade_info where grade_id = #{id}")
    boolean deleteGrade(Integer id);

    /**
     * 更新一个信息
     * @param gradeInfoPO
     * @return
     */
    @Update("update grade_info set grade_name = #{gradeName},grade_description = #{gradeDescription},grade_slogan = #{gradeSlogan} where grade_id = #{gradeId}")
    boolean updateGrade(GradeInfoPO gradeInfoPO);

    /**
     * 查询所有的信息
     * @return
     */
    @Select("select grade_id,grade_name,grade_description,grade_slogan from grade_info")
    List<GradeInfoPO> findAllGrade();

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    @Select("select grade_id,grade_name,grade_description,grade_slogan from grade_info where grade_id = #{id}")
    GradeInfoPO findGradeById(Integer id);

}
