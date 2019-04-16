package demik.springcloud.teachermanagementsystem8001.mapper;

import demik.springcloud.entity.domain.po.AwardInfoPO;
import demik.springcloud.entity.domain.vo.AwardGameVO;
import demik.springcloud.entity.domain.vo.AwardInfoVO;
import demik.springcloud.entity.domain.vo.AwardLevelVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/18 7:48 PM
 * @since JDK 1.8
 */
@Mapper
public interface AwardInfoMapper {

    /**
     * 查询所有的比赛
     * @return
     */
    @Select("SELECT award_game_id,award_game_name from award_game")
    List<AwardGameVO> findAllAwardGame();

    /**
     * 查询所有的奖级别
     * @return
     */
    @Select("SELECT award_level_id,award_level_name from award_level")
    List<AwardLevelVO> findAllAwardLevel();

    /**
     * 查询所有的教师获奖记录
     * @return
     */
    @Select("SELECT a.award_id,t.teacher_name,g.award_game_name,l.award_level_name,a.award_time from award_info as a,award_game as g,award_level as l,teacher_info as t\n" +
            " where a.teacher_id = t.teacher_id and a.award_game_id = g.award_game_id and a.award_level_id = l.award_level_id;")
    List<AwardInfoVO> findAllAwardInfo();

    /**
     * 删除一条教师获奖信息
     * @param id
     * @return
     */
    @Delete("delete from award_info where award_id = #{id}")
    boolean deleteAwardInfoById(Integer id);

    /**
     * 添加一条教师获奖信息
     * @param awardInfoPO
     * @return
     */
    @Insert("INSERT into award_info(award_game_id,teacher_id,award_level_id,award_time) VALUES(#{awardGameId},#{teacherId},#{awardLevelId},#{awardTime})")
    boolean addAwardInfo(AwardInfoPO awardInfoPO);

    /**
     * 添加一条比赛信息
     * @param awardGameVO
     * @return
     */
    @Options(useGeneratedKeys=true, keyProperty="awardGameId", keyColumn="award_game_id")
    @Insert("INSERT INTO award_game(award_game_name) values(#{awardGameName})")
    boolean addAwardGame(AwardGameVO awardGameVO);

    /**
     * 根据比赛的名字查询比赛
     * @param name
     * @return
     */
    @Select("SELECT award_game_id,award_game_name from award_game where award_game_name = #{name}")
    List<AwardGameVO> findAwardGameByName(String name);

    /**
     * 查询单个比赛
     * @param id
     * @return
     */
    @Select("SELECT award_game_id,award_game_name from award_game where award_game_id = #{id}")
    AwardGameVO findAwardGameById(Integer id);

    /**
     * 根据id查询获奖级别
     * @param awardLevelId
     * @return
     */
    @Select("SELECT award_level_id,award_level_name from award_level where award_level_id = #{awardLevelId}")
    AwardLevelVO getAwardLevelById(Integer awardLevelId);

    /**
     * 根据id查询教师获奖信息
     * @param id
     * @return
     */
    @Select("SELECT a.award_id,t.teacher_name,g.award_game_name,l.award_level_name,a.award_time from award_info as a,award_game as g,award_level as l,teacher_info as t " +
            " where a.teacher_id = t.teacher_id and a.award_game_id = g.award_game_id and a.award_level_id = l.award_level_id and a.award_id = #{id};")
    AwardInfoVO findAwardInfoById(Integer id);

    /**
     * 根据教师名称查询教师获奖信息
     * @param teacherName
     * @return
     */
    @Select("SELECT a.award_id,t.teacher_name,g.award_game_name,l.award_level_name,a.award_time from award_info as a,award_game as g,award_level as l,teacher_info as t " +
            " where a.teacher_id = t.teacher_id and a.award_game_id = g.award_game_id and a.award_level_id = l.award_level_id and t.teacher_name = #{teacherName};")
    List<AwardInfoVO> findAwardInfoByTeacherName(String teacherName);

    /**
     * 根据比赛名称查询教师获奖信息
     * @param gameName
     * @return
     */
    @Select("SELECT a.award_id,t.teacher_name,g.award_game_name,l.award_level_name,a.award_time from award_info as a,award_game as g,award_level as l,teacher_info as t " +
            " where a.teacher_id = t.teacher_id and a.award_game_id = g.award_game_id and a.award_level_id = l.award_level_id and g.award_game_name = #{gameName};")
    List<AwardInfoVO> findAwardInfoByGameName(String gameName);
}
