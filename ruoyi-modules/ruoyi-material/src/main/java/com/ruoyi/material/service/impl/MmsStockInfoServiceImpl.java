package com.ruoyi.material.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.material.mapper.MmsStockInfoMapper;
import com.ruoyi.material.domain.MmsStockInfo;
import com.ruoyi.material.service.IMmsStockInfoService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-27
 */
@Service
public class MmsStockInfoServiceImpl implements IMmsStockInfoService 
{
    @Autowired
    private MmsStockInfoMapper mmsStockInfoMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public MmsStockInfo selectMmsStockInfoById(Long id)
    {
        return mmsStockInfoMapper.selectMmsStockInfoById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param mmsStockInfo 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<MmsStockInfo> selectMmsStockInfoList(MmsStockInfo mmsStockInfo)
    {
        return mmsStockInfoMapper.selectMmsStockInfoList(mmsStockInfo);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param mmsStockInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertMmsStockInfo(MmsStockInfo mmsStockInfo)
    {
        mmsStockInfo.setCreateTime(DateUtils.getNowDate());
        return mmsStockInfoMapper.insertMmsStockInfo(mmsStockInfo);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param mmsStockInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateMmsStockInfo(MmsStockInfo mmsStockInfo)
    {
        mmsStockInfo.setUpdateTime(DateUtils.getNowDate());
        return mmsStockInfoMapper.updateMmsStockInfo(mmsStockInfo);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMmsStockInfoByIds(Long[] ids)
    {
        return mmsStockInfoMapper.deleteMmsStockInfoByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMmsStockInfoById(Long id)
    {
        return mmsStockInfoMapper.deleteMmsStockInfoById(id);
    }
}
