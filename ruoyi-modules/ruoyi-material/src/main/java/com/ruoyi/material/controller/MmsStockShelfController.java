package com.ruoyi.material.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.material.domain.MmsStockShelf;
import com.ruoyi.material.service.IMmsStockShelfService;
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
@RequestMapping("/shelf")
public class MmsStockShelfController extends BaseController
{
    @Autowired
    private IMmsStockShelfService mmsStockShelfService;

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("material:shelf:list")
    @GetMapping("/list")
    public TableDataInfo list(MmsStockShelf mmsStockShelf)
    {
        startPage();
        List<MmsStockShelf> list = mmsStockShelfService.selectMmsStockShelfList(mmsStockShelf);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("material:shelf:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MmsStockShelf mmsStockShelf)
    {
        List<MmsStockShelf> list = mmsStockShelfService.selectMmsStockShelfList(mmsStockShelf);
        ExcelUtil<MmsStockShelf> util = new ExcelUtil<MmsStockShelf>(MmsStockShelf.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @RequiresPermissions("material:shelf:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mmsStockShelfService.selectMmsStockShelfById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("material:shelf:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MmsStockShelf mmsStockShelf)
    {
        return toAjax(mmsStockShelfService.insertMmsStockShelf(mmsStockShelf));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("material:shelf:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MmsStockShelf mmsStockShelf)
    {
        return toAjax(mmsStockShelfService.updateMmsStockShelf(mmsStockShelf));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("material:shelf:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mmsStockShelfService.deleteMmsStockShelfByIds(ids));
    }
}
