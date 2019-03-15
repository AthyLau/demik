package demik.springcloud.studentmanagementsystem9002.mapper;

import demik.springcloud.entity.domain.vo.AClassInfoVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 2:38 PM
 * @since JDK 1.8
 */
@Mapper
public interface AClassInfoMapper {
    /**
     * 添加一个班级
     * @param aClassInfoVO
     * @return
     */
    @Insert("INSERT INTO aclass_info (aclass_name,aclass_description,aclass_slogan,grade_id,perfessional_id) " +
            "VALUES(#{aclassName},#{aclassDescription},#{aclassSlogan},#{gradeId},#{perfessionalId})")
    boolean addAClass(AClassInfoVO aClassInfoVO);
    /**
     * 删除一个班级
     * @param id
     * @return
     */
    @Delete("DELETE from aclass_info where aclass_id = #{aclassId}")
    boolean deleteAClass(Integer id);
    /**
     * 更新一个班级
     * @param aClassInfoVO
     * @return
     */
    @Update("update aclass_info set aclass_name = #{aclassName},aclass_description = #{aclassDescription},aclass_slogan = #{aclassSlogan},grade_id = #{gradeId},perfessional_id = #{perfessionalId} where aclass_id = #{aclassId}")
    boolean updateAClass(AClassInfoVO aClassInfoVO);

    /**
     * 查询所有班级的原始信息
     * @return
     */
    @Select("SELECT aclass_id,aclass_name,aclass_description,aclass_slogan,grade_id,perfessional_id from aclass_info")
    List<AClassInfoVO> findAllAClass();
    /**
     * 查询单个班级的原始信息
     * @return
     */
    @Select("SELECT aclass_id,aclass_name,aclass_description,aclass_slogan,grade_id,perfessional_id from aclass_info where aclass_id = #{id}")
    AClassInfoVO findAClassById(Integer id);
}
