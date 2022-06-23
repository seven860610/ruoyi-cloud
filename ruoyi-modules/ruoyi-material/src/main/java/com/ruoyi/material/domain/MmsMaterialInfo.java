package com.ruoyi.material.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 mms_material_info
 * 
 * @author ruoyi
 * @date 2022-06-16
 */
public class MmsMaterialInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物资ID */
    private Long id;

    /** 物资名称 */
    @Excel(name = "物资名称")
    private String materialName;

    /** 物资类型 */
    @Excel(name = "物资类型")
    private String materialType;

    /** 规格 */
    @Excel(name = "规格")
    private String specs;

    /** 厂家 */
    @Excel(name = "厂家")
    private String producer;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String picAddr;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setSpecs(String specs) 
    {
        this.specs = specs;
    }

    public String getSpecs() 
    {
        return specs;
    }
    public void setProducer(String producer) 
    {
        this.producer = producer;
    }

    public String getProducer() 
    {
        return producer;
    }
    public void setPicAddr(String picAddr) 
    {
        this.picAddr = picAddr;
    }

    public String getPicAddr() 
    {
        return picAddr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("materialName", getMaterialName())
            .append("materialType", getMaterialType())
            .append("specs", getSpecs())
            .append("producer", getProducer())
            .append("picAddr", getPicAddr())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
