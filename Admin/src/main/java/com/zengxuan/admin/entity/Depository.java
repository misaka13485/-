package com.zengxuan.admin.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 仓库
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("DEPOSITORY")
@ApiModel(value="Depository对象", description="仓库")
public class Depository implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private BigDecimal Id;

    @TableField("GOOD_ID")
    private BigDecimal goodId;

    @TableField("Amount")
    private BigDecimal amount;

    @TableField("DEP_ID")
    private String depId;

    @Override
    public String toString() {
        return "{" +
        "Id=" + Id +
        ", goodId=" + goodId +
        ", amount=" + amount +
        ", depId=" + depId +
        "}";
    }



}
