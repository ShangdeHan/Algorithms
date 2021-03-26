public class Sort {
    /*
    215. Kth Largest Element in an Array
    Given an integer array nums and an integer k, return the kth largest element in the array.
    Note that it is the kth largest element in the sorted order, not the kth distinct element.

    Example 1:
    Input: nums = [3,2,1,5,6,4], k = 2
    Output: 5

    Example 2:
    Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
    Output: 4
     */
    public int findKthLargest(int[] nums, int k) {
        //quickSort(nums, 0, nums.length-1);
        //return nums[nums.length-k];
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public void quickSort(int[] nums, int begin, int end){
        if(begin < end){
            int temp = nums[begin];
            int i = begin;
            int j = end;
            while(i < j){
                while(i < j && nums[j] > temp){
                    j--;
                }
                nums[i] = nums[j];
                while(i < j && nums[i] <= temp){
                    i++;
                }
                nums[j] = nums[i];
            }

            nums[i] = temp;
            quickSort(nums, begin, i-1);
            quickSort(nums, i+1, end);
        }
    }


    public int quickSelect(int[] nums, int begin, int end, int k){
        int pivot = begin;
        for(int i = begin; i < end; i++){
            if(nums[i] <= nums[end]){
                swap(nums, pivot++, i);
            }
        }
        swap(nums, pivot, end);

        int count = end - pivot + 1;
        if(count == k)return nums[pivot];
        if(count > k)return quickSelect(nums, pivot+1, end, k);
        return quickSelect(nums, begin, pivot-1, k-count);
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
