package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysExternalContact;

/**
 * 校外人员信息Mapper接口
 * 
 * @author ruoyi
 */
public interface SysExternalContactMapper 
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
     * 删除校外人员信息
     * 
     * @param contactId 校外人员信息主键
     * @return 结果
     */
    public int deleteSysExternalContactByContactId(Long contactId);

    /**
     * 批量删除校外人员信息
     * 
     * @param contactIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysExternalContactByContactIds(Long[] contactIds);
} 