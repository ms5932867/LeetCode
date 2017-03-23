class Solution {
public:
    vector<int> twoSum(vector<int> &numbers, int target) {
        vector<int> result;
        unordered_map<int, int> eleIndex; // element -> index in number
        for(int i = 0; i < numbers.size(); ++i){
            int comb = target - numbers[i];
            if(eleIndex.count(comb) > 0){
                int ret[2] = {eleIndex[comb], i};
                return vector<int>(ret, ret + 2);
            }
            eleIndex[numbers[i]] = i;
        }
        return vector<int>();
    }

};