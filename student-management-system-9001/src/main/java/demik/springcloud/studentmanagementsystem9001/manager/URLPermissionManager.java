package demik.springcloud.studentmanagementsystem9001.manager;

import demik.springcloud.studentmanagementsystem9001.mapper.URLPermissionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/30 4:53 PM
 * @since JDK 1.8
 */
@Repository
public class URLPermissionManager {
    @Autowired
    private URLPermissionsMapper urlPermissionsMapper;

    /**
     * 根据url获取权限id
     * @param url
     * @return
     */
    public String getPermissionByURL(String url) {
        return urlPermissionsMapper.getPermissionByURL(url);
    }
}
