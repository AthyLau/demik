package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/26 4:46 PM
 * @since JDK 1.8
 */
public class ClientSSODTO {
    /**
     * token
     */
    private TokenDTO tokenDTO;
    /**
     * 下一步登陆需要请求的url
     */
    private String url;
    /**
     * 请求格式
     */
    private String requestType;
    /**
     * json模版
     */
    private String jsonTemplate;
    public ClientSSODTO() {
    }

    public ClientSSODTO(TokenDTO tokenDTO, String url) {
        this.tokenDTO = tokenDTO;
        this.url = url;
    }

    public ClientSSODTO(TokenDTO tokenDTO, String url, String requestType, String jsonTemplate) {
        this.tokenDTO = tokenDTO;
        this.url = url;
        this.requestType = requestType;
        this.jsonTemplate = jsonTemplate;
    }

    @Override
    public String toString() {
        return "ClientSSODTO{" +
                "tokenDTO=" + tokenDTO +
                ", url='" + url + '\'' +
                ", requestType='" + requestType + '\'' +
                ", jsonTemplate='" + jsonTemplate + '\'' +
                '}';
    }

    public TokenDTO getTokenDTO() {
        return tokenDTO;
    }

    public void setTokenDTO(TokenDTO tokenDTO) {
        this.tokenDTO = tokenDTO;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getJsonTemplate() {
        return jsonTemplate;
    }

    public void setJsonTemplate(String jsonTemplate) {
        this.jsonTemplate = jsonTemplate;
    }
}
