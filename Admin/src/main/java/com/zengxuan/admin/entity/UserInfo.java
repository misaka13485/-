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
 * 
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("USER_INFO")
@ApiModel(value="UserInfo对象", description="")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private BigDecimal Id;

    @TableField("NAME")
    private String username;

    @TableField("TOKEN")
    private String token;

    @TableField("CREAT_TIME")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "密码")
    @TableField("USER_PASSWORD")
    private String userPassword;

    @Override
    public String toString() {
        return "{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                ", createTime=" + createTime +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }


}
