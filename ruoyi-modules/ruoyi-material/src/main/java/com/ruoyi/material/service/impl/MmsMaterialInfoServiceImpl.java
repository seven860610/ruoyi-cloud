package com.ruoyi.material.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.material.mapper.MmsMaterialInfoMapper;
import com.ruoyi.material.domain.MmsMaterialInfo;
import com.ruoyi.material.service.IMmsMaterialInfoService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-16
 */
@Service
public class MmsMaterialInfoServiceImpl implements IMmsMaterialInfoService 
{
    @Autowired
    private MmsMaterialInfoMapper mmsMaterialInfoMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public MmsMaterialInfo selectMmsMaterialInfoById(Long id)
    {
        return mmsMaterialInfoMapper.selectMmsMaterialInfoById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param mmsMaterialInfo 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<MmsMaterialInfo> selectMmsMaterialInfoList(MmsMaterialInfo mmsMaterialInfo)
    {
        return mmsMaterialInfoMapper.selectMmsMaterialInfoList(mmsMaterialInfo);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param mmsMaterialInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertMmsMaterialInfo(MmsMaterialInfo mmsMaterialInfo)
    {
        mmsMaterialInfo.setCreateTime(DateUtils.getNowDate());
        return mmsMaterialInfoMapper.insertMmsMaterialInfo(mmsMaterialInfo);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param mmsMaterialInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateMmsMaterialInfo(MmsMaterialInfo mmsMaterialInfo)
    {
        mmsMaterialInfo.setUpdateTime(DateUtils.getNowDate());
        return mmsMaterialInfoMapper.updateMmsMaterialInfo(mmsMaterialInfo);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMmsMaterialInfoByIds(Long[] ids)
    {
        return mmsMaterialInfoMapper.deleteMmsMaterialInfoByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMmsMaterialInfoById(Long id)
    {
        return mmsMaterialInfoMapper.deleteMmsMaterialInfoById(id);
    }
}
