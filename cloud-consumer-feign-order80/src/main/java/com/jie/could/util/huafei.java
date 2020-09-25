package com.jie.could.util;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/3
 * WWW https://github.com/j6l
 */
public class huafei {


    public static void main(String[] args) {
        // double hf=0.0;
        // Scanner sc = new Scanner( System.in );
        // System.out.println( "请输入秒：" );
        // double name = sc.nextInt();
        // if (name >= 60) {
        //     double i = name - 60;
        //     hf = Math.ceil( i / 60 ) * 0.3;
        //     hf += 0.5;
        // } else if (name >= 0) {
        //     hf = 0.5;
        // }
        // System.out.println( "话费为" + hf + "元" );


        ArrayList<Integer> list = new ArrayList<>();
        float sum = 0f;
        for (int i = 0; i < 10; i++) {
            list.add((int) (1 + Math.random() * (10 - 1 + 1)));
        }
        System.out.println( "排序前:  "+list.toString() );
        Collections.sort(list);
        System.out.println( "排序后:  "+list.toString() );

        list.remove( list.size()-1);
        list.remove(0);

        System.out.println( "排序后:  "+list.toString() );

        for (Integer i:list){
            sum +=i;
        }

        float i = sum / (float)list.size();
        System.out.println( "平均数为" + i );
    }
}
