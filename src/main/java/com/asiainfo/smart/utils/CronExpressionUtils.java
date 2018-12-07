package com.asiainfo.smart.utils;

import com.asiainfo.smart.common.annotation.Comment;
import com.asiainfo.smart.common.constants.CronExpression;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author king-pan
 * @date 2018/12/7
 * @Description ${DESCRIPTION}
 */
public class CronExpressionUtils {


    private CronExpressionUtils(){
        try{
            Field[] fields = CronExpression.class.getFields();
            for (Field field : fields) {
                if(field.isAnnotationPresent(Comment.class)){
                    Annotation a = field.getAnnotation(Comment.class);
                    if(null != a){
                        Method m = a.getClass().getMethod("value",null);
                        String desc = m.invoke(a, null).toString();
                        cronDesc.put(field.get(CronExpression.class).toString(), desc);
                    }
                }
            }
        }catch(Exception e){	e.printStackTrace();	}
    }

    /**
     * 保存所有任务表达式和描述
     */
    public static Map<String,String> cronDesc = new LinkedHashMap<String,String>();

    public Map getCronMap(){
        return cronDesc;
    }

    public static CronExpressionUtils getInstance(){
        return CronExpressionUtilsHelper.INSTANCE;
    }

    private static class CronExpressionUtilsHelper{
        private static final CronExpressionUtils INSTANCE = new CronExpressionUtils();
    }
}
