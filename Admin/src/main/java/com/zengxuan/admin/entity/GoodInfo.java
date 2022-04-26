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
 * 
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("GOOD_INFO")
@ApiModel(value="GoodInfo对象", description="")
public class GoodInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "货物id")
    @TableId(value = "GOODS_ID", type = IdType.AUTO)
    private BigDecimal goodsId;

    @ApiModelProperty(value = "货物名称")
    @TableField("GOOD_NAME")
    private String name;

    @ApiModelProperty(value = "货物尺寸")
    @TableField("GOOD_SIZE")
    private BigDecimal size;

    @Override
    public String toString() {
        return "{" +
                "goodsId=" + goodsId +
                ", name='" + name + '\'' +
                ", size=" + size +
                '}';
    }


}
