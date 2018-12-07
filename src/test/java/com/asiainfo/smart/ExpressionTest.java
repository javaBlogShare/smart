package com.asiainfo.smart;

import com.asiainfo.smart.utils.CronExpressionUtils;
import org.junit.Test;

/**
 * @author king-pan
 * @date 2018/12/7
 * @Description ${DESCRIPTION}
 */
public class ExpressionTest {


    @Test
    public void testCron(){

        System.out.println(CronExpressionUtils.getInstance().getCronMap());
    }
}
