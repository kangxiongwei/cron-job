package com.kxw;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        test();
        test("zhangsan");
        test("wangwu", "zhangsan", "lisi");
    }



    public static void test(String... a) {
        if (a != null && a.length > 0) {
            System.out.println(a[0]);
        } else {
            System.out.println("没有传a");
        }
    }
}
