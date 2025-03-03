package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysExternalContact;

/**
 * 校外人员信息Service接口
 * 
 * @author ruoyi
 */
public interface ISysExternalContactService 
{
    /**
     * 查询校外人员信息
     * 
     * @param contactId 校外人员信息主键
     * @return 校外人员信息
     */
    public SysExternalContact selectSysExternalContactByContactId(Long contactId);

    /**
     * 查询校外人员信息列表
     * 
     * @param sysExternalContact 校外人员信息
     * @return 校外人员信息集合
     */
    public List<SysExternalContact> selectSysExternalContactList(SysExternalContact sysExternalContact);

    /**
     * 新增校外人员信息
     * 
     * @param sysExternalContact 校外人员信息
     * @return 结果
     */
    public int insertSysExternalContact(SysExternalContact sysExternalContact);

    /**
     * 修改校外人员信息
     * 
     * @param sysExternalContact 校外人员信息
     * @return 结果
     */
    public int updateSysExternalContact(SysExternalContact sysExternalContact);

    /**
     * 批量删除校外人员信息
     * 
     * @param contactIds 需要删除的校外人员信息主键集合
     * @return 结果
     */
    public int deleteSysExternalContactByContactIds(Long[] contactIds);

    /**
     * 删除校外人员信息信息
     * 
     * @param contactId 校外人员信息主键
     * @return 结果
     */
    public int deleteSysExternalContactByContactId(Long contactId);
} 