package com.asiainfo.smart.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author king-pan
 * @date 2018/12/7
 * @Description ${DESCRIPTION}
 */
//@Component
public class BossPasswordHelper {


    //@Value("${boss.password}")
    private String password = "a264a295e1f58099";

    public String getPwd(String time, String id) {
        StringBuilder sb = new StringBuilder(password);
        sb.append(id).append(time);
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(sb.toString().getBytes());
        String md5 = new BigInteger(1, md.digest()).toString(16);
        return md5.length() == 32 ? md5 : fillMD5("0" + md5);
    }

    public String fillMD5(String md5){
        return md5.length()==32?md5:fillMD5("0"+md5);
    }
}
