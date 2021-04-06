/*
15. 3Sum
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
*/
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length-2; i++){
            for(int j = i+1; j <nums.length-1; j ++){
                int complement = 0-nums[i]-nums[j];
                if(map.containsKey(complement) && map.get(complement) > j){
                    list.add(Arrays.asList(nums[i], nums[j], complement));
                    j = map.get(nums[j]);
                }
            }
            i = map.get(nums[i]);
        }
        return list;
    }
