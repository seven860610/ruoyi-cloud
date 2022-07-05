package com.ruoyi.material.service.impl;

import java.util.List;

import com.ruoyi.common.core.exception.ServiceException;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.core.utils.bean.BeanValidators;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.system.api.domain.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(MmsMaterialInfoServiceImpl.class);

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

    /**
     * 导入用户数据
     *
     * @param materialList 用户数据列表
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importUser(List<MmsMaterialInfo> materialList, String operName)
    {
        if (StringUtils.isNull(materialList) || materialList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (MmsMaterialInfo material : materialList)
        {
            try
            {
                this.insertMmsMaterialInfo(material);
                successNum++;
                successMsg.append("<br/>" + successNum + "、账号 " + material.getMaterialName() + " 导入成功");

            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + material.getMaterialName()  + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
