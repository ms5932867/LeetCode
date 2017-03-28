class Solution {
public:
    int singleNumber(vector<int>& nums) {
        std::unordered_map<int, int> countMap;
        for (auto it = nums.begin(); it != nums.end(); it++){
            int value = *it;
            if (countMap.count(value) > 0)
                countMap[value] += 1;
            else
                countMap[value] = 0;
        }
        
        for( auto it = countMap.begin(); it != countMap.end(); ++it){
            if (it->second == 0)
                return it->first;
        }
    }
};

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int ans = 0;
        for (vector<int>::iterator it = nums.begin(); it != nums.end(); it++){
            ans ^= *it;
        }
        return ans;
    }
};