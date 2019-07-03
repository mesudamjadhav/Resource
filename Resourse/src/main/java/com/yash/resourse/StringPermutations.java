package com.yash.resourse;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

       static List<String> permutations = null;
       
       public StringPermutations() {
              permutations = new ArrayList<>();
       }
       
       public static void main(String[] args) {
       
              StringPermutations obj = new StringPermutations();
              
//              Scanner sc = new Scanner(System.in);
//              System.out.print("String : ");
              String s = "AAB";
       
              obj.permute(s, 0, s.length()-1);
              
              System.out.println("No. of permutations : " + permutations.size());
              System.out.println(permutations);
              
       }

       private void permute(String s, int start, int end) {
              if(start == end)
                     permutations.add(s);              
              else 
                     for(int i=start; i<=end; i++) {
                           s = swap(s, start, i);
                           permute(s, start+1, end);
                           s = swap(s, start, i);
                     }
       }

       private static String swap(String s, int i, int j) {
              char[] cArr = s.toCharArray();
              char temp = cArr[i];
              cArr[i] = cArr[j];
              cArr[j] = temp;
              
              return String.valueOf(cArr);
       }
}

