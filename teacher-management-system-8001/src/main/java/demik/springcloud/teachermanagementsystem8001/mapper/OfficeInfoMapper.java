package demik.springcloud.teachermanagementsystem8001.mapper;

import demik.springcloud.entity.domain.vo.OfficeInfoVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/15 11:16 PM
 * @since JDK 1.8
 */
@Mapper
public interface OfficeInfoMapper {

    /**
     * 添加一个教研室
     * @param
     * @return
     */
    @Insert("Insert into office_info(office_name,office_address,office_phone) VALUES(#{officeId},#{officeName},#{officeAddress},#{officePhone})")
    boolean addOfficeInfo(OfficeInfoVO officeInfoVO);

    /**
     * 删除一个教研室
     * @param officeId
     * @return
     */
    @Delete("delete from office_info where office_id = #{officeId}")
    boolean deleteOfficeInfo(Integer officeId);

    /**
     * 更新一个教研室信息
     * @param officeInfoVO
     * @return
     */
    @Update("update office_info set office_name = #{officeName},set office_address = #{officeAddress},set office_phone = #{officePhone} where office_id = #{officeId}")
    boolean updateOfficeInfo(OfficeInfoVO officeInfoVO);

    /**
     * 查询所有的教研室
     * @return
     */
    @Select("select office_id,office_name,office_address,office_phone from office_info")
    List<OfficeInfoVO> findAllOfficeInfo();

    /**
     * 查询单个教研室
     * @param officeId
     * @return
     */
    @Select("select office_id,office_name,office_address,office_phone from office_info where office_id = #{officeId}")
    OfficeInfoVO findOfficeInfoById(Integer officeId);
}
