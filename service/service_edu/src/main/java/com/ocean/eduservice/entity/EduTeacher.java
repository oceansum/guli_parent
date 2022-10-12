package com.ocean.eduservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * è®²å¸ˆ
 * </p>
 *
 * @author testjava
 * @since 2022-10-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduTeacher对象", description="è®²å¸ˆ")
public class EduTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "è®²å¸ˆID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "è®²å¸ˆå§“å")
    private String name;

    @ApiModelProperty(value = "è®²å¸ˆç®€ä»‹")
    private String intro;

    @ApiModelProperty(value = "è®²å¸ˆèµ„åŽ†,ä¸€å¥è¯è¯´æ˜Žè®²å¸ˆ")
    private String career;

    @ApiModelProperty(value = "å¤´è¡” 1é«˜çº§è®²å¸ˆ 2é¦–å¸­è®²å¸ˆ")
    private Integer level;

    @ApiModelProperty(value = "è®²å¸ˆå¤´åƒ")
    private String avatar;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false） 未删除")
    private Integer isDeleted;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间´")
    private Date gmtModified;


}
