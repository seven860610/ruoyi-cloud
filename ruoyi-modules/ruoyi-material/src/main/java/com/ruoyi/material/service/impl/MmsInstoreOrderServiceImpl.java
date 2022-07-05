package com.ruoyi.material.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.core.utils.SnowFlake;
import com.ruoyi.common.core.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.material.mapper.MmsInstoreOrderMapper;
import com.ruoyi.material.domain.MmsInstoreOrder;
import com.ruoyi.material.service.IMmsInstoreOrderService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-28
 */
@Service
public class MmsInstoreOrderServiceImpl implements IMmsInstoreOrderService 
{
    @Autowired
    private MmsInstoreOrderMapper mmsInstoreOrderMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param instockNo 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public MmsInstoreOrder selectMmsInstoreOrderByInstockNo(String instockNo)
    {
        return mmsInstoreOrderMapper.selectMmsInstoreOrderByInstockNo(instockNo);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param mmsInstoreOrder 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<MmsInstoreOrder> selectMmsInstoreOrderList(MmsInstoreOrder mmsInstoreOrder)
    {
        return mmsInstoreOrderMapper.selectMmsInstoreOrderList(mmsInstoreOrder);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param mmsInstoreOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertMmsInstoreOrder(MmsInstoreOrder mmsInstoreOrder)
    {
        /*SnowFlake idWorker = new SnowFlake(0, 0);
        long id = idWorker.nextId();
        mmsInstoreOrder.setInstockNo("Ins"+String.valueOf(id));*/
        mmsInstoreOrder.setCreateTime(DateUtils.getNowDate());
        return mmsInstoreOrderMapper.insertMmsInstoreOrder(mmsInstoreOrder);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param mmsInstoreOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateMmsInstoreOrder(MmsInstoreOrder mmsInstoreOrder)
    {
        mmsInstoreOrder.setUpdateTime(DateUtils.getNowDate());
        return mmsInstoreOrderMapper.updateMmsInstoreOrder(mmsInstoreOrder);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param instockNos 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMmsInstoreOrderByInstockNos(String[] instockNos)
    {
        return mmsInstoreOrderMapper.deleteMmsInstoreOrderByInstockNos(instockNos);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param instockNo 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMmsInstoreOrderByInstockNo(String instockNo)
    {
        return mmsInstoreOrderMapper.deleteMmsInstoreOrderByInstockNo(instockNo);
    }
}
