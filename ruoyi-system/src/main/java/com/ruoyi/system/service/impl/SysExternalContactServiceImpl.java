package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysExternalContactMapper;
import com.ruoyi.system.domain.SysExternalContact;
import com.ruoyi.system.service.ISysExternalContactService;

/**
 * 校外人员信息Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysExternalContactServiceImpl implements ISysExternalContactService 
{
    @Autowired
    private SysExternalContactMapper sysExternalContactMapper;

    /**
     * 查询校外人员信息
     * 
     * @param contactId 校外人员信息主键
     * @return 校外人员信息
     */
    @Override
    public SysExternalContact selectSysExternalContactByContactId(Long contactId)
    {
        return sysExternalContactMapper.selectSysExternalContactByContactId(contactId);
    }

    /**
     * 查询校外人员信息列表
     * 
     * @param sysExternalContact 校外人员信息
     * @return 校外人员信息
     */
    @Override
    public List<SysExternalContact> selectSysExternalContactList(SysExternalContact sysExternalContact)
    {
        return sysExternalContactMapper.selectSysExternalContactList(sysExternalContact);
    }

    /**
     * 新增校外人员信息
     * 
     * @param sysExternalContact 校外人员信息
     * @return 结果
     */
    @Override
    public int insertSysExternalContact(SysExternalContact sysExternalContact)
    {
        return sysExternalContactMapper.insertSysExternalContact(sysExternalContact);
    }

    /**
     * 修改校外人员信息
     * 
     * @param sysExternalContact 校外人员信息
     * @return 结果
     */
    @Override
    public int updateSysExternalContact(SysExternalContact sysExternalContact)
    {
        return sysExternalContactMapper.updateSysExternalContact(sysExternalContact);
    }

    /**
     * 批量删除校外人员信息
     * 
     * @param contactIds 需要删除的校外人员信息主键
     * @return 结果
     */
    @Override
    public int deleteSysExternalContactByContactIds(Long[] contactIds)
    {
        return sysExternalContactMapper.deleteSysExternalContactByContactIds(contactIds);
    }

    /**
     * 删除校外人员信息信息
     * 
     * @param contactId 校外人员信息主键
     * @return 结果
     */
    @Override
    public int deleteSysExternalContactByContactId(Long contactId)
    {
        return sysExternalContactMapper.deleteSysExternalContactByContactId(contactId);
    }
} 