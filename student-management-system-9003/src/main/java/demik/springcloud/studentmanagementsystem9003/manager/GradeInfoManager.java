package demik.springcloud.studentmanagementsystem9003.manager;

import com.google.common.collect.Lists;
import demik.springcloud.entity.domain.doo.GradeInfoDO;
import demik.springcloud.entity.domain.po.GradeInfoPO;
import demik.springcloud.studentmanagementsystem9003.mapper.GradeInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 2:37 PM
 * @since JDK 1.8
 */
@Repository
public class GradeInfoManager {
    @Autowired
    private GradeInfoMapper gradeInfoMapper;
    /**
     * 添加一个
     * @param gradeInfoDO
     * @return
     */
    public boolean addGrade(GradeInfoDO gradeInfoDO){
        GradeInfoPO gradeInfoPO = new GradeInfoPO();
        BeanUtils.copyProperties(gradeInfoDO,gradeInfoPO);
        return gradeInfoMapper.addGrade(gradeInfoPO);
    }

    /**
     * 删除一个
     * @param id
     * @return
     */
    public boolean deleteGrade(Integer id){
        return gradeInfoMapper.deleteGrade(id);
    }

    /**
     * 更新一个信息
     * @param gradeInfoDO
     * @return
     */
    public boolean updateGrade(GradeInfoDO gradeInfoDO){
        GradeInfoPO gradeInfoPO = new GradeInfoPO();
        BeanUtils.copyProperties(gradeInfoDO,gradeInfoPO);
        return gradeInfoMapper.updateGrade(gradeInfoPO);
    }

    /**
     * 查询所有的信息
     * @return
     */
    public List<GradeInfoDO> findAllGrade(){
        List<GradeInfoPO> pos = gradeInfoMapper.findAllGrade();
        List<GradeInfoDO> dos = Lists.newArrayList();
        pos.forEach(x->{
            GradeInfoDO gradeInfoDO = new GradeInfoDO();
            BeanUtils.copyProperties(x,gradeInfoDO);
            dos.add(gradeInfoDO);
        });
        return dos;
    }

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    public GradeInfoDO findGradeById(Integer id){
        GradeInfoPO gradeInfoPO = gradeInfoMapper.findGradeById(id);
        if(gradeInfoPO==null){
            return null;
        }
        GradeInfoDO gradeInfoDO = new GradeInfoDO();
        BeanUtils.copyProperties(gradeInfoPO,gradeInfoDO);
        return gradeInfoDO;
    }
}
