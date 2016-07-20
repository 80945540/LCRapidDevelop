package com.xiaochao.lcrapiddevelop.Util;

import java.util.Random;

/**
 * Created by Administrator on 2016/1/7.
 */
public class sysUtil {
    public static String youzySing(){
        Random random=new Random();
        String str=UserUtil.times();
        char[] chars=str.toCharArray();
        for(int i=0;i<chars.length;i++){
            switch (chars[i]){
                case '0':
                    chars[i]='Z';
                    break;
                case '1':
                    chars[i]='O';
                    break;
                case '2':
                    chars[i]='T';
                    break;
                case '3':
                    chars[i]='t';
                    break;
                case '4':
                    chars[i]='F';
                    break;
                case '5':
                    chars[i]='f';
                    break;
                case '6':
                    chars[i]='S';
                    break;
                case '7':
                    chars[i]='s';
                    break;
                case '8':
                    chars[i]='E';
                    break;
                case '9':
                    chars[i]='N';
                    break;
                case '-':
                    chars[i]='L';
                    break;
                case ':':
                    chars[i]='D';
                    break;
                case ' ':
                    chars[i]='B';
                    break;
            }
        }
        int i=random.nextInt(6)+2;
        str=new String(chars);
        String newString = str.substring(0, i) + "C" + str.substring(i, str.length());
        return newString;
    }
}
