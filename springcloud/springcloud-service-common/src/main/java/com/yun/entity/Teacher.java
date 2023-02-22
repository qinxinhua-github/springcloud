package com.yun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 教师类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "教师类")
public class Teacher {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "地址")
    private String addr;
    @ApiModelProperty(value = "电话")
    private String number;

    /*public Teacher(){}

    public Teacher(String id,String name,String addr,String number){
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.number = number;
    }*/
}
