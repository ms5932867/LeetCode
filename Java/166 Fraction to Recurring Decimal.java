public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0) || (numerator == 0) ? "" : "-";
        sb.append(sign);
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append(num / den);
        
        long remain = num % den;
        if(remain == 0) return sb.toString();
        
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(!map.containsKey(remain)){
            map.put(remain, sb.length());
            remain = 10 * remain;
            sb.append(remain / den);
            remain %= denominator;
        }
        if(remain != 0){
            int index = map.get(remain);
            sb.insert(index, '(');
            sb.append(')');
        }
        else{
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
        
    }
}