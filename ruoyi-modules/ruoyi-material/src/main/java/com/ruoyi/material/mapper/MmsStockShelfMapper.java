package com.ruoyi.material.mapper;

import java.util.List;
import com.ruoyi.material.domain.MmsStockShelf;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-27
 */
public interface MmsStockShelfMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public MmsStockShelf selectMmsStockShelfById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param mmsStockShelf 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<MmsStockShelf> selectMmsStockShelfList(MmsStockShelf mmsStockShelf);

    /**
     * 新增【请填写功能名称】
     * 
     * @param mmsStockShelf 【请填写功能名称】
     * @return 结果
     */
    public int insertMmsStockShelf(MmsStockShelf mmsStockShelf);

    /**
     * 修改【请填写功能名称】
     * 
     * @param mmsStockShelf 【请填写功能名称】
     * @return 结果
     */
    public int updateMmsStockShelf(MmsStockShelf mmsStockShelf);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteMmsStockShelfById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMmsStockShelfByIds(Long[] ids);
}
