// submit in contest
class Solution {
    public int monotoneIncreasingDigits(int N) {
        LinkedList<Integer> digits = new LinkedList<>();
        
        while (N > 0) {
            int cur = N % 10;
            N /= 10;
            digits.addFirst(cur);
        }
        int res = 0;
        int i  = 0;
        for (; i < digits.size(); i++) {
            if (i == 0 || digits.get(i) >= digits.get(i - 1)) {
                res = res * 10 + digits.get(i);
            }
            else {
                break;
            }
        }
        
        if (i < digits.size()) {
            int toDec = i - 1;
            while (toDec > 0 && digits.get(toDec) == digits.get(toDec - 1)) {
                toDec--;
                res /= 10;
            }

            int numOf9ToAppend = 0;
            if (toDec == 0) {
                res = digits.get(toDec) - 1;
                numOf9ToAppend = digits.size() - 1;
            }
            else {
                res = res / 10 * 10 + digits.get(toDec) - 1;
                numOf9ToAppend = digits.size() - toDec - 1;
            }

            while (numOf9ToAppend > 0) {
                res = res * 10 + 9;
                numOf9ToAppend--;
            }
        }
                
        return res;
    }
}

// After contest
class Solution {
    public int monotoneIncreasingDigits(int N) {
        String number = String.valueOf(N);
        char[] res = number.toCharArray(); 
        int index = 0;

        while (index < res.length) {
            char cur = res[index];
            if (index + 1 < res.length && cur > res[index + 1]) {
                while (--index >= 0 && res[index] == cur) {}
                res[++index] = (char)(cur - 1);
                while (++index < res.length) {
                    res[index] = '9';
                }
            }
            else {
                res[index++] = cur;
            }
        }

        return Integer.valueOf(String.valueOf(res));
    }
}