package com.ruoyi.material.controller;

import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.utils.SnowFlake;
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
import com.ruoyi.material.domain.MmsInstoreOrder;
import com.ruoyi.material.service.IMmsInstoreOrderService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-06-28
 */
@RestController
@RequestMapping("/order")
public class MmsInstoreOrderController extends BaseController
{
    @Autowired
    private IMmsInstoreOrderService mmsInstoreOrderService;

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("material:order:list")
    @GetMapping("/list")
    public TableDataInfo list(MmsInstoreOrder mmsInstoreOrder)
    {
        startPage();
        List<MmsInstoreOrder> list = mmsInstoreOrderService.selectMmsInstoreOrderList(mmsInstoreOrder);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("material:order:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MmsInstoreOrder mmsInstoreOrder)
    {
        List<MmsInstoreOrder> list = mmsInstoreOrderService.selectMmsInstoreOrderList(mmsInstoreOrder);
        ExcelUtil<MmsInstoreOrder> util = new ExcelUtil<MmsInstoreOrder>(MmsInstoreOrder.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @RequiresPermissions("material:order:query")
    @GetMapping(value = "/{instockNo}")
    public AjaxResult getInfo(@PathVariable("instockNo") String instockNo)
    {
        return AjaxResult.success(mmsInstoreOrderService.selectMmsInstoreOrderByInstockNo(instockNo));
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("material:order:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping(value = "/add")
    public AjaxResult add(@RequestBody MmsInstoreOrder mmsInstoreOrder)
    {
        return toAjax(mmsInstoreOrderService.insertMmsInstoreOrder(mmsInstoreOrder));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("material:order:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping(value = "/update")
    public AjaxResult edit(@RequestBody MmsInstoreOrder mmsInstoreOrder)
    {
        return toAjax(mmsInstoreOrderService.updateMmsInstoreOrder(mmsInstoreOrder));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("material:order:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{instockNos}")
    public AjaxResult remove(@PathVariable String[] instockNos)
    {
        return toAjax(mmsInstoreOrderService.deleteMmsInstoreOrderByInstockNos(instockNos));
    }

    /**
     * 获取入库单号
     */
    /**
     * 获取【请填写功能名称】详细信息
     */
    @RequiresPermissions("material:order:createInstockNo")
    @GetMapping(value = "/createInstockNo")
    public AjaxResult createInstockNo()
    {
        SnowFlake idWorker = new SnowFlake(0, 0);
        long id = idWorker.nextId();
        String instockNo = "Ins"+String.valueOf(id);
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("instockNo",instockNo);
        return AjaxResult.success(hashMap);
    }
}
