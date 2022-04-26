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
 * 需求表
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("NEED")
@ApiModel(value="Need对象", description="需求表")
public class Need implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "流水号")
    @TableId(value = "ID", type = IdType.AUTO)
    private BigDecimal Id;

    @ApiModelProperty(value = "需求人")
    @TableField("NEEDER")
    private BigDecimal needer;

    @TableField("AMOUNT")
    private BigDecimal amount;

    @TableField("GOOD_ID")
    private BigDecimal goodId;

    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "状态")
    @TableField("STATUS")
    private String status;

    @Override
    public String toString() {
        return "{" +
                "Id=" + Id +
                ", needer=" + needer +
                ", amount=" + amount +
                ", GoodId=" + goodId +
                ", createTime=" + createTime +
                ", status=" + status +
                "}";
    }

}
