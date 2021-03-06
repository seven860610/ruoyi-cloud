package com.ruoyi.material.mapper;

import java.util.List;
import com.ruoyi.material.domain.MmsInstoreOrder;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-28
 */
public interface MmsInstoreOrderMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param instockNo 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteMmsInstoreOrderByInstockNo(String instockNo);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param instockNos 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMmsInstoreOrderByInstockNos(String[] instockNos);
}
