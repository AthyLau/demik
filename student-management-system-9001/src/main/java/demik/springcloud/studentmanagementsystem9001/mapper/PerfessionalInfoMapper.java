package demik.springcloud.studentmanagementsystem9001.mapper;

import demik.springcloud.entity.domain.vo.PerfessionalInfoVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 2:36 PM
 * @since JDK 1.8
 */
@Mapper
public interface PerfessionalInfoMapper {
    /**
     * 添加一个专业
     * @param perfessionalInfoVO
     * @return
     */
    @Insert("INSERT INTO perfessional_info(perfessional_name,perfessional_description,perfessional_slogan) values(#{perfessionalName},#{perfessionalDescription},#{perfessionalSlogan})")
    boolean addPerfessionalInfo(PerfessionalInfoVO perfessionalInfoVO);

    /**
     * 更新一个专业
     * @param perfessionalInfoVO
     * @return
     */
    @Update("UPDATE perfessional_info set perfessional_name = #{perfessionalName},perfessional_description = #{perfessionalDescription},perfessional_slogan = #{perfessionalSlogan} where perfessional_id = #{perfessionalId}")
    boolean updatePerfessionalInfo(PerfessionalInfoVO perfessionalInfoVO);

    /**
     * 删除一个专业
     * @param perrfessionalId
     * @return
     */
    @Delete("DELETE from perfessional_info where perfessional_id = #{perfessionalId}")
    boolean deletePerfessionalInfo(Integer perrfessionalId);

    /**
     * 查询所有专业
     * @return
     */
    @Select("SELECT perfessional_id,perfessional_name,perfessional_description,perfessional_slogan from perfessional_info")
    List<PerfessionalInfoVO> findAllPerfessionalInfo();

    /**
     * 查找单个专业
     * @return
     */
    @Select("SELECT perfessional_id,perfessional_name,perfessional_description,perfessional_slogan from perfessional_info where perfessional_id = #{perfessionalId}")
    PerfessionalInfoVO findPerfessionalInfoById(Integer perfessionalId);
}
