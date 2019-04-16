package demik.springcloud.studentmanagementsystem9001.service;

import demik.springcloud.studentmanagementsystem9001.manager.URLPermissionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/30 4:53 PM
 * @since JDK 1.8
 */
@Service
public class URLPermissionService {
    @Autowired
    private URLPermissionManager urlPermissionManager;

    /**
     * 根据url获取权限id
     * @param url
     * @return
     */
    public String getPermissionByURL(String url){
        return urlPermissionManager.getPermissionByURL(url);
    }
}
