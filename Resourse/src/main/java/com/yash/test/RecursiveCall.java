package com.yash.test;
public class RecursiveCall {

       public static void main(String[] args) {
              int result = recursion(5);
              System.out.println("======");
              System.out.println(result);
       }

       private static int recursion(int i) {
              int result = 0;
              
              if(i>0) {
                     result = i + recursion(i-1);
                     System.out.println(result);
              }
              return result;
       }
}
