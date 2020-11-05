package com.gakki.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: ssm_system
 * @description: 日期转字符串  字符串  转 日期
 * @author: Gakki
 * @create: 2020-10-31 02:53
 **/
public class DateUtils {

    /**
     *
     * @param date  时间
     * @param patt  转换格式
     * @return   根据格式返回  时间字符串
     */
    public static String DateToString(Date date,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String str = sdf.format(date);
        return str;
    }

    /**
     *
     * @param str   时间字符串
     * @param patt  格式
     * @return  根据格式返回   时间
     * @throws ParseException
     */
    public static  Date StringToDate(String str, String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(str);
        return parse;
    }


}
