package com.ruoyi.material.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 mms_stock_info
 * 
 * @author ruoyi
 * @date 2022-06-27
 */
public class MmsStockInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 仓库ID */
    private Long id;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String stockName;

    /** 仓库类型 */
    @Excel(name = "仓库类型")
    private String stockType;

    /** 管理员 */
    @Excel(name = "管理员")
    private String stockManager;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStockName(String stockName) 
    {
        this.stockName = stockName;
    }

    public String getStockName() 
    {
        return stockName;
    }
    public void setStockType(String stockType) 
    {
        this.stockType = stockType;
    }

    public String getStockType() 
    {
        return stockType;
    }
    public void setStockManager(String stockManager) 
    {
        this.stockManager = stockManager;
    }

    public String getStockManager() 
    {
        return stockManager;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("stockName", getStockName())
            .append("stockType", getStockType())
            .append("stockManager", getStockManager())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
