package service;

public class TaskSalvationService {

    public static String reverseLetter(String s){

        if(s==null) return "";

        char[] sChar = s.toCharArray();
        int left = 0;
        int right = sChar.length-1;
        char temp;

        while (left<right){

            if(!Character.isLetter(sChar[left])){
                left++;
                continue;
            }
            if(!Character.isLetter(sChar[right])) {
                right--;
                continue;
            }

            temp=sChar[left];
            sChar[left]=sChar[right];
            sChar[right]=temp;
            left++;
            right--;
        }

        return new String(sChar);
    }
}
