/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var visited = new Map();
    for(var i = 0; i < nums.length; i++){
        var rem = target - nums[i];
        if(visited.has(rem)){
            return Array(visited.get(rem), i);
        }
        visited.set(nums[i], i);
    }
    
    return Array();
};