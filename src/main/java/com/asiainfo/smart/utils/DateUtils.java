package com.asiainfo.smart.utils;

import com.sun.org.apache.regexp.internal.RE;
import org.joda.time.DateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/8/9
 * Time: 下午5:26
 * Description: No Description
 */
public class DateUtils {

    public static final String YYYYMMDD = "yyyyMMdd";

    public static  final String TIME = "yyyyMMddHHmmss";

    public static final String DAY_YYYY_MM_DD = "yyyy-MM-dd";


    public static String getCurrtDay() {
        DateTime today = new DateTime();
        return today.toString(YYYYMMDD);
    }

    public static String getCurrentTime(){
        DateTime time = new DateTime();
        return  time.toString(TIME);
    }

    public static String getCurrtDay(String formate) {
        DateTime today = new DateTime();
        return today.toString(formate);
    }

    /**
     * 获取当前日期的N天日期: n为正整数是表示N天后的日期，n为负整数表示N天前的日期
     *
     * @param n 日期偏移量
     * @return 日期字符串
     */
    public static String getBeforeNDay(int n) {
        DateTime now = new DateTime();
        DateTime tomorrow = now.plusDays(n);
        return tomorrow.toString(YYYYMMDD);
    }

    /**
     * 获取当前日期的N天日期: n为正整数是表示N天后的日期，n为负整数表示N天前的日期
     *
     * @param n      日期偏移量
     * @param format 日期格式
     * @return 指定格式日期字符串
     */
    public static String getBeforeNDay(int n, String format) {
        DateTime now = new DateTime();
        DateTime tomorrow = now.plusDays(n);
        return tomorrow.toString(format);
    }

}
