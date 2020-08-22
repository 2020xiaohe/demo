package com.ffcs.demo.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: TODO
 * @author: hemb
 * @date: 2020年08月22日 9:43
 */
@Data
public class DayOrderStatistics {

    private Date date;

    private BigDecimal totalprice;

    private int cjOrder;
}
