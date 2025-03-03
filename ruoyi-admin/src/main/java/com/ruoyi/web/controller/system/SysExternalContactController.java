package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysExternalContact;
import com.ruoyi.system.service.ISysExternalContactService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 校外人员信息Controller
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/contact")
public class SysExternalContactController extends BaseController
{
    @Autowired
    private ISysExternalContactService sysExternalContactService;

    /**
     * 查询校外人员信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:contact:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysExternalContact sysExternalContact)
    {
        startPage();
        List<SysExternalContact> list = sysExternalContactService.selectSysExternalContactList(sysExternalContact);
        return getDataTable(list);
    }

    /**
     * 导出校外人员信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:contact:export')")
    @Log(title = "校外人员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysExternalContact sysExternalContact)
    {
        List<SysExternalContact> list = sysExternalContactService.selectSysExternalContactList(sysExternalContact);
        ExcelUtil<SysExternalContact> util = new ExcelUtil<SysExternalContact>(SysExternalContact.class);
        util.exportExcel(response, list, "校外人员信息数据");
    }

    /**
     * 获取校外人员信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:contact:query')")
    @GetMapping(value = "/{contactId}")
    public AjaxResult getInfo(@PathVariable("contactId") Long contactId)
    {
        return success(sysExternalContactService.selectSysExternalContactByContactId(contactId));
    }

    /**
     * 新增校外人员信息
     */
    @PreAuthorize("@ss.hasPermi('system:contact:add')")
    @Log(title = "校外人员信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysExternalContact sysExternalContact)
    {
        return toAjax(sysExternalContactService.insertSysExternalContact(sysExternalContact));
    }

    /**
     * 修改校外人员信息
     */
    @PreAuthorize("@ss.hasPermi('system:contact:edit')")
    @Log(title = "校外人员信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysExternalContact sysExternalContact)
    {
        return toAjax(sysExternalContactService.updateSysExternalContact(sysExternalContact));
    }

    /**
     * 删除校外人员信息
     */
    @PreAuthorize("@ss.hasPermi('system:contact:remove')")
    @Log(title = "校外人员信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{contactIds}")
    public AjaxResult remove(@PathVariable Long[] contactIds)
    {
        return toAjax(sysExternalContactService.deleteSysExternalContactByContactIds(contactIds));
    }
} 