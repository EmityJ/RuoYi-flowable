package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysProjectMapper;
import com.ruoyi.system.domain.SysProject;
import com.ruoyi.system.service.ISysProjectService;

/**
 * 项目管理Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysProjectServiceImpl implements ISysProjectService 
{
    @Autowired
    private SysProjectMapper sysProjectMapper;

    /**
     * 查询项目
     * 
     * @param projectId 项目ID
     * @return 项目
     */
    @Override
    public SysProject selectSysProjectById(Long projectId)
    {
        return sysProjectMapper.selectSysProjectById(projectId);
    }

    /**
     * 查询项目列表
     * 
     * @param sysProject 项目
     * @return 项目
     */
    @Override
    public List<SysProject> selectSysProjectList(SysProject sysProject)
    {
        return sysProjectMapper.selectSysProjectList(sysProject);
    }

    /**
     * 新增项目
     * 
     * @param sysProject 项目
     * @return 结果
     */
    @Override
    public int insertSysProject(SysProject sysProject)
    {
        return sysProjectMapper.insertSysProject(sysProject);
    }

    /**
     * 修改项目
     * 
     * @param sysProject 项目
     * @return 结果
     */
    @Override
    public int updateSysProject(SysProject sysProject)
    {
        return sysProjectMapper.updateSysProject(sysProject);
    }

    /**
     * 批量删除项目
     * 
     * @param projectIds 需要删除的项目ID
     * @return 结果
     */
    @Override
    public int deleteSysProjectByIds(Long[] projectIds)
    {
        return sysProjectMapper.deleteSysProjectByIds(projectIds);
    }

    /**
     * 删除项目信息
     * 
     * @param projectId 项目ID
     * @return 结果
     */
    @Override
    public int deleteSysProjectById(Long projectId)
    {
        return sysProjectMapper.deleteSysProjectById(projectId);
    }
} 