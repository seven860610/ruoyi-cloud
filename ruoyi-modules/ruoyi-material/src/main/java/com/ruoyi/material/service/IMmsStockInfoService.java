package com.ruoyi.material.service;

import java.util.List;
import com.ruoyi.material.domain.MmsStockInfo;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-06-27
 */
public interface IMmsStockInfoService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public MmsStockInfo selectMmsStockInfoById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param mmsStockInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<MmsStockInfo> selectMmsStockInfoList(MmsStockInfo mmsStockInfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param mmsStockInfo 【请填写功能名称】
     * @return 结果
     */
    public int insertMmsStockInfo(MmsStockInfo mmsStockInfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param mmsStockInfo 【请填写功能名称】
     * @return 结果
     */
    public int updateMmsStockInfo(MmsStockInfo mmsStockInfo);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteMmsStockInfoByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteMmsStockInfoById(Long id);
}
