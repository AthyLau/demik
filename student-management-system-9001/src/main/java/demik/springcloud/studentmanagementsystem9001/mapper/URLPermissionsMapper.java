package demik.springcloud.studentmanagementsystem9001.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/30 4:53 PM
 * @since JDK 1.8
 */
@Mapper
public interface URLPermissionsMapper {

    /**
     * 根据url获取权限id
     * @param url
     * @return
     */
    @Select("select permission_id from urls_permissions where url = #{url}")
    Integer getPermissionByURL(String url);
}
