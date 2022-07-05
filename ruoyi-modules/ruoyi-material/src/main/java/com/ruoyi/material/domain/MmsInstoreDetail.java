package com.ruoyi.material.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 mms_instore_detail
 * 
 * @author ruoyi
 * @date 2022-06-28
 */
public class MmsInstoreDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 入库单号 */
    @Excel(name = "入库单号")
    private String instockNo;

    /** 入库单号 */
    @Excel(name = "货架编号")
    private String shelfNo;

    /** 物资编号 */
    @Excel(name = "物资编号")
    private String materialNo;

    /** 物资名称 */
    @Excel(name = "物资名称")
    private String materialName;

    /** 类型 */
    @Excel(name = "类型")
    private String materialType;

    /** 规格 */
    @Excel(name = "规格")
    private String materialSpecs;

    /** 数量 */
    @Excel(name = "数量")
    private Long nums;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setInstockNo(String instockNo) 
    {
        this.instockNo = instockNo;
    }

    public String getInstockNo() 
    {
        return instockNo;
    }
    public void setMaterialNo(String materialNo) 
    {
        this.materialNo = materialNo;
    }

    public String getMaterialNo() 
    {
        return materialNo;
    }
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setMaterialType(String materialType) 
    {
        this.materialType = materialType;
    }

    public String getMaterialType() 
    {
        return materialType;
    }
    public void setMaterialSpecs(String materialSpecs) 
    {
        this.materialSpecs = materialSpecs;
    }

    public String getMaterialSpecs() 
    {
        return materialSpecs;
    }
    public void setNums(Long nums) 
    {
        this.nums = nums;
    }

    public Long getNums() 
    {
        return nums;
    }
    public String getShelfNo() {
        return shelfNo;
    }

    public void setShelfNo(String shelfNo) {
        this.shelfNo = shelfNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("instockNo", getInstockNo())
            .append("shelfNo",getShelfNo())
            .append("materialNo", getMaterialNo())
            .append("materialName", getMaterialName())
            .append("materialType", getMaterialType())
            .append("materialSpecs", getMaterialSpecs())
            .append("nums", getNums())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
