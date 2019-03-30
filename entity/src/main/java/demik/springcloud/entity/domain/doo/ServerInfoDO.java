package demik.springcloud.entity.domain.doo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/26 4:52 PM
 * @since JDK 1.8
 */
public class ServerInfoDO {
    /**
     * 机器的ip
     */
    private String ip;
    /**
     * 机器的名字
     */
    private String name;

    public ServerInfoDO() {
    }

    public ServerInfoDO(String ip, String name) {
        this.ip = ip;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ServerInfoDO{" +
                "ip='" + ip + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
