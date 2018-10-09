package com.demo.yunfei.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author : yunfei
 * @date : 2018/10/9 10:12
 */
public class ComparatorUtil {

    /**
     * 1.8 Comparator排序
     */
    public void comparatorFunc(){
        List<Human> humans = new ArrayList<>(3);
        humans.add(new Human("Sarah", 10));
        humans.add(new Human("Jack", 12));
        humans.add(new Human("Jack", 10));
        Collections.sort(humans,Comparator.comparing(Human::getName));
        humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
    }
}
