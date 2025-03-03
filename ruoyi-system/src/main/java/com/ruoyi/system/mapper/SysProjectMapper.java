package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysProject;

/**
 * 项目管理Mapper接口
 * 
 * @author ruoyi
 */
public interface SysProjectMapper 
{
    /**
     * 查询项目
     * 
     * @param projectId 项目ID
     * @return 项目
     */
    public SysProject selectSysProjectById(Long projectId);

    /**
     * 查询项目列表
     * 
     * @param sysProject 项目
     * @return 项目集合
     */
    public List<SysProject> selectSysProjectList(SysProject sysProject);

    /**
     * 新增项目
     * 
     * @param sysProject 项目
     * @return 结果
     */
    public int insertSysProject(SysProject sysProject);

    /**
     * 修改项目
     * 
     * @param sysProject 项目
     * @return 结果
     */
    public int updateSysProject(SysProject sysProject);

    /**
     * 删除项目
     * 
     * @param projectId 项目ID
     * @return 结果
     */
    public int deleteSysProjectById(Long projectId);

    /**
     * 批量删除项目
     * 
     * @param projectIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysProjectByIds(Long[] projectIds);
} 