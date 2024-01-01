package com.maoxian.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 套餐
 *
 * @author Lin
 * @date 2023/12/31 11:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Setmeal {
    private Long id;
    /**
     * 分类id
     */
    private Long categoryId;
    /**
     * 套餐名称
     */
    private String name;
    /**
     * 套餐价格
     */
    private BigDecimal price;
    /**
     * 状态 0:停用 1:启用
     */
    private Integer status;
    /**
     * 描述信息
     */
    private String description;
    /**
     * 图片
     */
    private String image;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 创建人
     */
    private Long createUser;
    /**
     * 修改人
     */
    private Long updateUser;
}
