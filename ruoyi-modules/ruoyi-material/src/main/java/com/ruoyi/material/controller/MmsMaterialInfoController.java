package com.ruoyi.material.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.utils.ServletUtils;
import com.ruoyi.common.security.service.TokenService;
import com.ruoyi.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.material.domain.MmsMaterialInfo;
import com.ruoyi.material.service.IMmsMaterialInfoService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-06-16
 */
@RestController
@RequestMapping("/info")
public class MmsMaterialInfoController extends BaseController
{
    @Autowired
    private IMmsMaterialInfoService mmsMaterialInfoService;

    @Autowired
    TokenService tokenService;

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("material:info:list")
    @GetMapping("/list")
    public TableDataInfo list(MmsMaterialInfo mmsMaterialInfo)
    {
        startPage();
        List<MmsMaterialInfo> list = mmsMaterialInfoService.selectMmsMaterialInfoList(mmsMaterialInfo);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("material:info:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MmsMaterialInfo mmsMaterialInfo)
    {
        List<MmsMaterialInfo> list = mmsMaterialInfoService.selectMmsMaterialInfoList(mmsMaterialInfo);
        ExcelUtil<MmsMaterialInfo> util = new ExcelUtil<MmsMaterialInfo>(MmsMaterialInfo.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @RequiresPermissions("material:info:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mmsMaterialInfoService.selectMmsMaterialInfoById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("material:info:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MmsMaterialInfo mmsMaterialInfo)
    {
        return toAjax(mmsMaterialInfoService.insertMmsMaterialInfo(mmsMaterialInfo));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("material:info:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MmsMaterialInfo mmsMaterialInfo)
    {
        return toAjax(mmsMaterialInfoService.updateMmsMaterialInfo(mmsMaterialInfo));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("material:info:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mmsMaterialInfoService.deleteMmsMaterialInfoByIds(ids));
    }


    /**
     * 物资导入
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("material:info:import")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<MmsMaterialInfo> util = new ExcelUtil<MmsMaterialInfo>(MmsMaterialInfo.class);
        List<MmsMaterialInfo> materiaList = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = mmsMaterialInfoService.importUser(materiaList, operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException
    {
        ExcelUtil<MmsMaterialInfo> util = new ExcelUtil<MmsMaterialInfo>(MmsMaterialInfo.class);
        util.importTemplateExcel(response, "物资数据");
    }
}
