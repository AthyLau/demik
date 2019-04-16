package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/12 2:18 PM
 * @since JDK 1.8
 */
public class GameNameDTO {
    private String gameName;

    public GameNameDTO() {
    }

    public GameNameDTO(String gameName) {
        this.gameName = gameName;
    }

    @Override
    public String toString() {
        return "GameNameDTO{" +
                "gameName='" + gameName + '\'' +
                '}';
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
