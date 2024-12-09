class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        generateSubsets(nums,0,new ArrayList<>(),result);
        return result;
    }
    private void generateSubsets(int[] nums, int i, List<Integer>current, List<List<Integer>>result){
        if(i==nums.length){ //if we've considered all elements
            result.add(new ArrayList<>(current)); // Add the current subset to the result
            return;
        }
        //Exclude the current element
        generateSubsets(nums,i+1,current,result);
        current.add(nums[i]); //Include the current element
        generateSubsets(nums,i+1,current,result);
        current.remove(current.size()-1); // Remove the last added element
    }
}
