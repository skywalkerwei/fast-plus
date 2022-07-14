package com.imguo.model.mall.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 用户查询
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TestQuery{

    @NotNull(message = "age为空")
    @Min(value = 1, message = "age最小值为 1")
    Integer age;

}

