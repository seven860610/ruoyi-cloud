package com.ruoyi.material.service;

import java.util.List;
import com.ruoyi.material.domain.MmsMaterialInfo;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-06-16
 */
public interface IMmsMaterialInfoService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public MmsMaterialInfo selectMmsMaterialInfoById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param mmsMaterialInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<MmsMaterialInfo> selectMmsMaterialInfoList(MmsMaterialInfo mmsMaterialInfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param mmsMaterialInfo 【请填写功能名称】
     * @return 结果
     */
    public int insertMmsMaterialInfo(MmsMaterialInfo mmsMaterialInfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param mmsMaterialInfo 【请填写功能名称】
     * @return 结果
     */
    public int updateMmsMaterialInfo(MmsMaterialInfo mmsMaterialInfo);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteMmsMaterialInfoByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteMmsMaterialInfoById(Long id);
}
