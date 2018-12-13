package com.cskaoyan.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class J11_MD5Util {
    static String MD5_ALGORITHM = "md5";
    public static String SHA512_ALGORITHM = "SHA-512";

    public static String getMd5(String content){
        try {
            //1\拿到MD5的摘要
            MessageDigest instance = MessageDigest.getInstance(MD5_ALGORITHM);
            //content 转换成一个字节
            byte[] contentBytes = content.getBytes();
            //md5值 加密算法的过程
            byte[] digest = instance.digest(contentBytes);
            String result = byteArrayToString(digest);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getMd5(String content, String sault){
        try {
            //1\拿到MD5的摘要
            MessageDigest instance = MessageDigest.getInstance(MD5_ALGORITHM);
            //content 转换成一个字节
            byte[] contentBytes = content.getBytes();
            //md5值 加密算法的过程
            byte[] digest = instance.digest(contentBytes);
            String result = byteArrayToString(digest);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }




    private static String byteArrayToString(byte[] digest) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte bt: digest)
        {
            //不使用强制转换
            /*int x = (int)bt;
            System.out.println("int 型:" + x);*/
            int i = bt & 0x00FF;
            //System.out.println("与运算：" + i);
            //转换成16进制的数字
            String s = Integer.toHexString(i);
            if (s.length() == 1)
            {
                stringBuffer.append("0");
            }
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }

}
