package com.maoxian.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 地址簿
 *
 * @author Lin
 * @date 2023/12/31 10:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBook {
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 收货人
     */
    private String consignee;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 性别 0:女 1:男
     */
    private String sex;
    /**
     * 省级区划编号
     */
    private String provinceCode;
    /**
     * 省级名称
     */
    private String provinceName;
    /**
     * 市级区划编号
     */
    private String cityCode;
    /**
     * 市级名称
     */
    private String cityName;
    /**
     * 区级区划编号
     */
    private String districtCode;
    /**
     * 区级名称
     */
    private String districtName;
    /**
     * 详细地址
     */
    private String detail;
    /**
     * 标签
     */
    private String label;
    /**
     * 是否默认 0:否 1:是
     */
    private Integer isDefault;
}
