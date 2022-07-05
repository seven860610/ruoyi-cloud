package com.ruoyi.material.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 mms_instore_order
 * 
 * @author ruoyi
 * @date 2022-06-28
 */
public class MmsInstoreOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 入库单号 */
    private String instockNo;

    /** 入库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date instockTime;

    /** 入库仓库 */
    @Excel(name = "入库仓库")
    private String stock;

    /** 入库总数 */
    @Excel(name = "入库总数")
    private Long pennum;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 审核人 */
    @Excel(name = "审核人")
    private String reviewer;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reviewTime;

    /** 操作员 */
    @Excel(name = "操作员")
    private String operator;

    public void setInstockNo(String instockNo) 
    {
        this.instockNo = instockNo;
    }
    public String getInstockNo() 
    {
        return instockNo;
    }

    public void setInstockTime(Date instockTime) 
    {
        this.instockTime = instockTime;
    }
    public Date getInstockTime() 
    {
        return instockTime;
    }

    public void setPennum(Long pennum)
    {
        this.pennum = pennum;
    }
    public Long getPennum()
    {
        return pennum;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }
    public String getStatus() 
    {
        return status;
    }

    public void setReviewer(String reviewer) 
    {
        this.reviewer = reviewer;
    }
    public String getReviewer() 
    {
        return reviewer;
    }

    public void setReviewTime(Date reviewTime) 
    {
        this.reviewTime = reviewTime;
    }
    public Date getReviewTime() 
    {
        return reviewTime;
    }

    public void setOperator(String operator) 
    {
        this.operator = operator;
    }
    public String getOperator() 
    {
        return operator;
    }

    public String getStock() {
        return stock;
    }
    public void setStock(String stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("instockNo", getInstockNo())
            .append("instockTime", getInstockTime())
            .append("stock",getStock())
            .append("pennum", getPennum())
            .append("status", getStatus())
            .append("reviewer", getReviewer())
            .append("reviewTime", getReviewTime())
            .append("operator", getOperator())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
