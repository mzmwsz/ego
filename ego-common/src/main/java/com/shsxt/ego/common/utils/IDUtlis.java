package com.shsxt.ego.common.utils;

import java.util.Random;

/** 各种id生成策略
 * Created by 10170 on 2019/7/3.
 */

public class IDUtlis {
    //图片名的生成
    public static String genImageName(){
        //取当前时间的长整型值包含毫秒数
        long millis = System.currentTimeMillis();
        //long millis = System.nanoTime();
        //加上三位随机数
        Random random  = new Random();
        int end3 = random.nextInt(1000);
        //如果不足三位前面补0
        String str = millis + String.format("%03d",end3);
        return str;
    }

    //商品id生成器
    public static Long genItemId(){
        //取当前时间的长整型值包含毫秒数
        long millis = System.currentTimeMillis();
        //加上两位随机数
        Random random = new Random();
        int end = random.nextInt(99);
        //如果不足两位补0
        String str = millis+String.format("%02d",end);
        long id = new Long(str);
        return id;
    }

    public static void main(String[] args) {
        for(int i=0;i< 100;i++)
            System.out.println(genItemId());
    }
}
