package com.demo.yunfei.demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : yunfei
 * @date : 2018/10/9 10:24
 */
public class StreamUtil {

    /**
     * 1.8 将流中的数据转成集合
     */
    public void forList(){
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> collect = list.stream().map(i -> i * 10).collect(Collectors.toList());
        Set<Integer> set = list.stream().map(integer -> integer * 10).collect(Collectors.toSet());
        list.stream().map(integer -> integer*10).collect(Collectors.toMap(key ->"key"+key/10,value ->"value"+value ));
        TreeSet<Integer> treeSet = Stream.of(1, 2, 3).collect(Collectors.toCollection(TreeSet::new));

    }

    /**
     * 1.8  拼接
     */
    public void joining(){
        // a,b,c
        List<String> list2 = Arrays.asList("a", "b", "c");
        String result = list2.stream().collect(Collectors.joining(","));

        // Collectors.joining(",")的结果是：a,b,c  然后再将结果 x + "d"操作, 最终返回a,b,cd
        String str= Stream.of("a", "b", "c").collect(Collectors.collectingAndThen(Collectors.joining(","), x -> x + "d"));

    }

    /**
     * 1.8  运算
     */
    public void calculate(){
        List<Integer> list = Arrays.asList(1, 2, 3);
        Integer integer = list.stream().collect(Collectors.collectingAndThen(Collectors.maxBy((o1, o2) -> o1 - o2), Optional::get));
        Integer integer1 = list.stream().collect(Collectors.collectingAndThen(Collectors.minBy((o1, o2) -> o1 - o2), Optional::get));
        Integer collect = list.stream().collect(Collectors.summingInt(value -> value));
        Double collect1 = list.stream().collect(Collectors.averagingDouble(value -> value));
    }

    public void testReducing(){

        // sum: 是每次累计计算的结果，b是Function的结果
        System.out.println(Stream.of(1, 3, 4).collect(Collectors.reducing(0, x -> x + 1, (sum, b) -> {
            System.out.println(sum + "-" + b);
            return sum + b;
        })));


        // 下面代码是对reducing函数功能实现的描述，用于理解reducing的功能
        int sum = 0;
        List<Integer> list3 = Arrays.asList(1, 3, 4);
        for (Integer item : list3) {
            int b = item + 1;
            System.out.println(sum + "-" + b);
            sum = sum + b;
        }
        System.out.println(sum);


        // 注意reducing可以用于更复杂的累计计算，加减乘除或者更复杂的操作
        // result = 2 * 4 * 5 = 40
        System.out.println(Stream.of(1, 3, 4).collect(Collectors.reducing(1, x -> x + 1, (result, b) -> {
            System.out.println(result + "-" + b);
            return result * b;
        })));
    }


    public void testGroupBy(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 奇偶数分组：奇数分一组，偶数分一组
        // groupingBy(Function<? super T, ? extends K> classifier) 参数是Function类型，Function返回值可以是要分组的条件，也可以是要分组的字段
        // 返回的结果是Map，其中key的数据类型为Function体中计算类型，value是List<T>类型，为分组的结果
        Map<Boolean, List<Integer>> result = list.stream().collect(Collectors.groupingBy(item -> item % 2 == 0));
        // {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}
        System.out.println(result);


        // partitioningBy 用于分成两组的情况
        Map<Boolean, List<Integer>> twoPartiton = list.stream().collect(Collectors.partitioningBy(item -> item % 2 == 0));
        System.out.println(twoPartiton);


        User user = new User(1L, "zhangsan", 1);
        User user2 = new User(2L, "lisi", 2);
        User user3 = new User(3L, "wangwu", 3);
        User user4 = new User(4L, "fengliu", 1);
        List<User> users = Arrays.asList(user, user2, user3, user4);
        // 根据某个字段进行分组
        Map<Integer, List<User>> userGroup = users.stream().collect(Collectors.groupingBy(item -> item.getType()));

        /**
         * key 为要分组的字段
         * value 分组的结果
         * {
         *  1=[User{id=1, username='zhangsan', type=1}, User{id=4, username='fengliu', type=1}],
         *  2=[User{id=2, username='lisi', type=2}],
         *  3=[User{id=3, username='wangwu', type=3}]
         * }
         */
        System.out.println(userGroup);
    }


}
