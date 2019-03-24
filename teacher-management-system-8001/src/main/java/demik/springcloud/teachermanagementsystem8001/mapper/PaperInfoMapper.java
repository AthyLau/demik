package demik.springcloud.teachermanagementsystem8001.mapper;

import demik.springcloud.entity.domain.dto.PublishedPaperInfoDTO;
import demik.springcloud.entity.domain.po.PaperPublishedPO;
import demik.springcloud.entity.domain.po.PaperTypePO;
import demik.springcloud.entity.domain.vo.PaperInfoVO;
import demik.springcloud.entity.domain.vo.PaperOriginInfoVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 1:44 AM
 * @since JDK 1.8
 */
@Mapper
public interface PaperInfoMapper {
    /**
     * 查询所有的论文信息
     * @return
     */
    @Select("SELECT p.paper_id,p.paper_name,t.paper_type_name from paper_info as p,paper_type as t where p.paper_type_id = t.paper_type_id;")
    List<PaperInfoVO> findAllPaperInfo();

    /**
     * 添加论文
     * @param paperOriginInfoVO
     * @return
     */
    @Options(useGeneratedKeys=true, keyProperty="paperId", keyColumn="paper_id")
    @Insert("INSERT into paper_info(paper_name,paper_type_id) values(#{paperName},#{paperTypeId})")
    boolean addPaperOriginInfo(PaperOriginInfoVO paperOriginInfoVO);

    /**
     * 查询所有的论文类型
     * @return
     */
    @Select("select paper_type_id,paper_type_name from paper_type")
    List<PaperTypePO> findAllPaperType();

    /**
     * 删除一条教师发布论文信息
     * @param id
     * @return
     */
    @Delete("delete from published_paper_info where id = #{id}")
    boolean deletePaperOriginInfo(Integer id);

    /**
     * 查询所有的教师发布论文信息
     * @return
     */
    @Select("SELECT pp.id,te.teacher_name,p.paper_name,t.paper_type_name,pp.published_time from published_paper_info as pp,paper_info as p,paper_type as t,teacher_info as te " +
            "where pp.paper_id = p.paper_id and p.paper_type_id = t.paper_type_id and te.teacher_id = pp.teacher_id;")
    List<PublishedPaperInfoDTO> PublishedPaperInfoDTO();

    /**
     * 添加一条教师发布论文信息
     * @param paperPublishedPO
     * @return
     */
    @Insert("Insert into published_paper_info(paper_id,teacher_id) VALUES(#{paperId},#{teacherId})")
    boolean addPublishedPaperInfo(PaperPublishedPO paperPublishedPO);

    /**
     * 根据名字查询论文发布信息
     * @param paperName
     * @return
     */
    @Select("select paper_id from paper_info where paper_name = #{paperName}")
    List<Integer> findPaperInfoByName(String paperName);
}
