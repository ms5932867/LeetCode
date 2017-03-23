public class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        char[] str = s.toCharArray();
        for(int i = 0, j = str.length - 1; i < j;){
            if(set.contains(str[i]) && set.contains(str[j])){
                char tmp = str[i];
                str[i] = str[j];
                str[j] = tmp;
                i++;
                j--;
            }
            else if(!set.contains(str[i])) i++;
            else j--;
        }
        return new String(str);
    }
}