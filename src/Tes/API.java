package Tes;

import org.junit.Test;

import java.util.*;

public class API {


    /*public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,2,3,4,5,7,8},6));
    }

    private static int binarySearch(int[] drinks, int temp) {
        //二分查找，查找到最右边的那个 数 小于 temp的
        int i =0,j = drinks.length;
        while(i<j){
            int mid=i+(j-i)/2;
            if(drinks[mid]>temp){
                j=mid;
            }else{
                i=mid+1;
            }
        }
        return i;
    }*/

    @Test
    public void test(){
        char a = '.';
        System.out.println(a-'0');
    }

    @Test
    public void test2(){
        System.out.println(1<<3);
    }

    @Test
    public void test3(){
//        int a = 'a';

//        System.out.println(a - 97);
//        System.out.println('b' - 97);


//        int a = 97;
//        char c = (char) a;
//        String s = String.valueOf(a);
//        System.out.println(s);

         char a = 'a';
         int b = a;
        System.out.println(b);

    }

    @Test
    public void test4(){
        System.out.println(2 | 3 <<1);
    }

    @Test
    public void test5(){
        System.out.println("abcabcab".indexOf("vvvv",0));
    }

    @Test
    public void test6(){
        StringBuilder a = new StringBuilder();

        a.append("c").append("b").append("e").append("w");

//        a.deleteCharAt(2);
//        System.out.println(a);

        System.out.println(a.deleteCharAt(4));

    }

    @Test
    public void test7(){
        if(false) {
            if (true) {
                System.out.println("3333333333333333");
            }
        }


        System.out.println("4444444444444444444444444444");
        System.out.println("4444444444444444444444444444444444");
    }

    public static void main(String[] args) {
        int x = 1;
        while(true){
            if(x%2==1 && x%3==2 && x%5==4 && x%6==5 && x%7 ==0){
                System.out.print(x);
                break;
            }
            x++;
        }
    }
    @Test
    public void test8(){
        Set<Integer> a = new HashSet<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        Iterator it = a.iterator();
        System.out.println(  it.next());
    }

    @Test
    public void test9(){
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        Collections.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //o2 = 1，2  o1 = 2，3
                System.out.println(o2 +"+"+ o1);
                System.out.println(a);
                return o2 - o1;
                //为负数  倒叙
                //为正数  正序
            }
        });

        System.out.println(a);
    }

    @Test
    public void test10(){
        System.out.println(Integer.bitCount(10000));
    }

    @Test
    public void test11(){

        Integer[] a = {6,7,9,1,3,8};
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                /*
                   6 2 7 1 3 8

                        o1 = 2 o2 = 6
                             7      2
                             7      6
                             1      6
                             1      2
                             3      6
                             3      2
                             8      3
                             8      7

                    return -1; 结果：8,3,1,7,2,6
                    return 1; 6 2 7 1 3 8
                    return 0 ; 不变
                    return o1 - o2;  1 2 3 6 7 8
                    return o2 - o1;  8 7 6 3 2 1

                 */
                System.out.println("---------");
                System.out.print(o1 + " ");
                System.out.println(o2);
                System.out.println("=====");
                for (Integer integer : a) {
                    System.out.print(integer + " ");
                }
                System.out.println();
                return o1 - o2;

            }
        });
        for (Integer integer : a) {
            System.out.println(integer);
        }


    }

    static Integer[] a = {1,2,3};
    @Test
    public void test12(){

        Arrays.sort(a , new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                System.out.println(o1 - o2);
                return o1 - o2;
                /*
                    o1 o2
                    2   1
                    3   2

                    1 2 3

                    2 1 3

                    3 2 1
                 */
            }
        });

        for (Integer integer : a) {
            System.out.println(integer);
        }
    }

    @Test
    public void test13(){
        List<Integer> a = new ArrayList<>();

        a.add(1,2);

    }
}
