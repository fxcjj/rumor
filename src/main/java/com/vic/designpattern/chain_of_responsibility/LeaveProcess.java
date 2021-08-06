package com.vic.designpattern.chain_of_responsibility;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 请求
 */
@Data
@AllArgsConstructor
public class LeaveProcess {

    /**
     * 请求标题
     */
    private String title;

    /**
     * 请求原因
     */
    private String content;

    /**
     * 请假天数
     */
    private Integer days;
}
