package com.ruoyi.material.service;

import java.util.List;
import com.ruoyi.material.domain.MmsInstoreOrder;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-06-28
 */
public interface IMmsInstoreOrderService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param instockNo 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public MmsInstoreOrder selectMmsInstoreOrderByInstockNo(String instockNo);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param mmsInstoreOrder 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<MmsInstoreOrder> selectMmsInstoreOrderList(MmsInstoreOrder mmsInstoreOrder);

    /**
     * 新增【请填写功能名称】
     * 
     * @param mmsInstoreOrder 【请填写功能名称】
     * @return 结果
     */
    public int insertMmsInstoreOrder(MmsInstoreOrder mmsInstoreOrder);

    /**
     * 修改【请填写功能名称】
     * 
     * @param mmsInstoreOrder 【请填写功能名称】
     * @return 结果
     */
    public int updateMmsInstoreOrder(MmsInstoreOrder mmsInstoreOrder);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param instockNos 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteMmsInstoreOrderByInstockNos(String[] instockNos);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param instockNo 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteMmsInstoreOrderByInstockNo(String instockNo);
}
