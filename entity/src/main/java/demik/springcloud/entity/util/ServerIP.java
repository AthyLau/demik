package demik.springcloud.entity.util;

import demik.springcloud.entity.domain.doo.ServerInfoDO;

import java.net.InetAddress;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/26 4:49 PM
 * @since JDK 1.8
 */
public class ServerIP {
    public static ServerInfoDO getServerIp(){
        ServerInfoDO serverInfoDO = new ServerInfoDO();
        try {
            InetAddress addr = InetAddress.getLocalHost();
            String ip=addr.getHostAddress().toString(); //获取本机ip
            String hostName=addr.getHostName().toString(); //获取本机计算机名称
            System.out.println("ServerIP"+ip);
            System.out.println("ServerName"+hostName);
            serverInfoDO.setIp(ip);
            serverInfoDO.setName(hostName);
        }catch (Exception e){
            System.out.println("获取本机ip失败");
        }
        return serverInfoDO;
    }
}
