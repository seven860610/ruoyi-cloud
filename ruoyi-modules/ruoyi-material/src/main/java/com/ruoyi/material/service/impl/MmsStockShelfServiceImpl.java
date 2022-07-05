package com.ruoyi.material.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.material.mapper.MmsStockShelfMapper;
import com.ruoyi.material.domain.MmsStockShelf;
import com.ruoyi.material.service.IMmsStockShelfService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-27
 */
@Service
public class MmsStockShelfServiceImpl implements IMmsStockShelfService 
{
    @Autowired
    private MmsStockShelfMapper mmsStockShelfMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public MmsStockShelf selectMmsStockShelfById(Long id)
    {
        return mmsStockShelfMapper.selectMmsStockShelfById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param mmsStockShelf 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<MmsStockShelf> selectMmsStockShelfList(MmsStockShelf mmsStockShelf)
    {
        return mmsStockShelfMapper.selectMmsStockShelfList(mmsStockShelf);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param mmsStockShelf 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertMmsStockShelf(MmsStockShelf mmsStockShelf)
    {
        mmsStockShelf.setCreateTime(DateUtils.getNowDate());
        return mmsStockShelfMapper.insertMmsStockShelf(mmsStockShelf);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param mmsStockShelf 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateMmsStockShelf(MmsStockShelf mmsStockShelf)
    {
        mmsStockShelf.setUpdateTime(DateUtils.getNowDate());
        return mmsStockShelfMapper.updateMmsStockShelf(mmsStockShelf);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMmsStockShelfByIds(Long[] ids)
    {
        return mmsStockShelfMapper.deleteMmsStockShelfByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMmsStockShelfById(Long id)
    {
        return mmsStockShelfMapper.deleteMmsStockShelfById(id);
    }
}
