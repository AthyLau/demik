package demik.springcloud.entity.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Function: token
 *
 * @author liubing
 * Date: 2018/10/30 3:45 PM
 * @since JDK 1.8
 */
public class TokenDTO {
    /**
     * 令牌
     */
    @NotBlank(message = "令牌不能为空")
    @ApiModelProperty("令牌")
    private String token;

    public TokenDTO(String token) {
        this.token = token;
    }

    public TokenDTO() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenVO{" +
                "token='" + token + '\'' +
                '}';
    }
}

