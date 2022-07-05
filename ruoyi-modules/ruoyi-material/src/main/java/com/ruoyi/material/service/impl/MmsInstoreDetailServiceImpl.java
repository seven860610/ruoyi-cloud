package com.ruoyi.material.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.material.mapper.MmsInstoreDetailMapper;
import com.ruoyi.material.domain.MmsInstoreDetail;
import com.ruoyi.material.service.IMmsInstoreDetailService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-28
 */
@Service
public class MmsInstoreDetailServiceImpl implements IMmsInstoreDetailService 
{
    @Autowired
    private MmsInstoreDetailMapper mmsInstoreDetailMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public MmsInstoreDetail selectMmsInstoreDetailById(Long id)
    {
        return mmsInstoreDetailMapper.selectMmsInstoreDetailById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param mmsInstoreDetail 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<MmsInstoreDetail> selectMmsInstoreDetailList(MmsInstoreDetail mmsInstoreDetail)
    {
        return mmsInstoreDetailMapper.selectMmsInstoreDetailList(mmsInstoreDetail);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param mmsInstoreDetail 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertMmsInstoreDetail(MmsInstoreDetail mmsInstoreDetail)
    {
        mmsInstoreDetail.setCreateTime(DateUtils.getNowDate());
        return mmsInstoreDetailMapper.insertMmsInstoreDetail(mmsInstoreDetail);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param mmsInstoreDetail 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateMmsInstoreDetail(MmsInstoreDetail mmsInstoreDetail)
    {
        mmsInstoreDetail.setUpdateTime(DateUtils.getNowDate());
        return mmsInstoreDetailMapper.updateMmsInstoreDetail(mmsInstoreDetail);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMmsInstoreDetailByIds(Long[] ids)
    {
        return mmsInstoreDetailMapper.deleteMmsInstoreDetailByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMmsInstoreDetailById(Long id)
    {
        return mmsInstoreDetailMapper.deleteMmsInstoreDetailById(id);
    }
}
