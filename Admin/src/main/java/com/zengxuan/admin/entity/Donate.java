package com.zengxuan.admin.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 捐赠记录
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("DONATE")
@ApiModel(value="Donate对象", description="捐赠记录")
public class Donate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "ID", type = IdType.AUTO)
    private BigDecimal Id;

    @ApiModelProperty(value = "货物号")
    @TableField("GOODS_ID")
    private BigDecimal goodsId;

    @ApiModelProperty(value = "总计")
    @TableField("AMOUNT")
    private BigDecimal amount;

    @ApiModelProperty(value = "创建日期")
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "捐献人ID")
    @TableField("DONATER")
    private BigDecimal donater;

    @ApiModelProperty(value = "状态")
    @TableField("STATUS")
    private String status;

    @Override
    public String toString() {
        return "{" +
                "Id=" + Id +
                ", goodsId=" + goodsId +
                ", amount=" + amount +
                ", createTime=" + createTime +
                ", donater=" + donater +
                ", status=" + status +
                "}";
    }


}
