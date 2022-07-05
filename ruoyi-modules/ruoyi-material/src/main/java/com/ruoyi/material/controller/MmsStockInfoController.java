package com.ruoyi.material.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.material.domain.MmsStockInfo;
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
import com.ruoyi.material.service.IMmsStockInfoService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-06-27
 */
@RestController
@RequestMapping("/stock")
public class MmsStockInfoController extends BaseController
{
    @Autowired
    private IMmsStockInfoService mmsStockInfoService;

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("material:stock:list")
    @GetMapping("/list")
    public TableDataInfo list(MmsStockInfo mmsStockInfo)
    {
        startPage();
        List<MmsStockInfo> list = mmsStockInfoService.selectMmsStockInfoList(mmsStockInfo);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("material:stock:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MmsStockInfo mmsStockInfo)
    {
        List<MmsStockInfo> list = mmsStockInfoService.selectMmsStockInfoList(mmsStockInfo);
        ExcelUtil<MmsStockInfo> util = new ExcelUtil<MmsStockInfo>(MmsStockInfo.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @RequiresPermissions("material:stock:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mmsStockInfoService.selectMmsStockInfoById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("material:stock:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping(value="/add")
    public AjaxResult add(@RequestBody MmsStockInfo mmsStockInfo)
    {
        return toAjax(mmsStockInfoService.insertMmsStockInfo(mmsStockInfo));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("material:stock:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MmsStockInfo mmsStockInfo)
    {
        return toAjax(mmsStockInfoService.updateMmsStockInfo(mmsStockInfo));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("material:stock:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mmsStockInfoService.deleteMmsStockInfoByIds(ids));
    }
}
