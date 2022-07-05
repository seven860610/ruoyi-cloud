package com.ruoyi.material.service;

import java.util.List;
import com.ruoyi.material.domain.MmsInstoreDetail;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-06-28
 */
public interface IMmsInstoreDetailService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public MmsInstoreDetail selectMmsInstoreDetailById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param mmsInstoreDetail 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<MmsInstoreDetail> selectMmsInstoreDetailList(MmsInstoreDetail mmsInstoreDetail);

    /**
     * 新增【请填写功能名称】
     * 
     * @param mmsInstoreDetail 【请填写功能名称】
     * @return 结果
     */
    public int insertMmsInstoreDetail(MmsInstoreDetail mmsInstoreDetail);

    /**
     * 修改【请填写功能名称】
     * 
     * @param mmsInstoreDetail 【请填写功能名称】
     * @return 结果
     */
    public int updateMmsInstoreDetail(MmsInstoreDetail mmsInstoreDetail);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteMmsInstoreDetailByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteMmsInstoreDetailById(Long id);
}
