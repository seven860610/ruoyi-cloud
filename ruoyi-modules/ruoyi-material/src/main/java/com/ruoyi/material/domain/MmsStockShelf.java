package com.ruoyi.material.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 mms_stock_shelf
 * 
 * @author ruoyi
 * @date 2022-06-27
 */
public class MmsStockShelf extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 货架ID */
    private Long id;

    /** 仓库ID */
    @Excel(name = "仓库ID")
    private Long stockId;

    /** 货架编号 */
    @Excel(name = "货架编号")
    private String shelfNo;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStockId(Long stockId) 
    {
        this.stockId = stockId;
    }

    public Long getStockId() 
    {
        return stockId;
    }
    public void setShelfNo(String shelfNo) 
    {
        this.shelfNo = shelfNo;
    }

    public String getShelfNo() 
    {
        return shelfNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("stockId", getStockId())
            .append("shelfNo", getShelfNo())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
