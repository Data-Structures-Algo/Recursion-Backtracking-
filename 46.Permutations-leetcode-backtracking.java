class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        backtrack(nums,new ArrayList<>(),result);
        return result;

    }
    private void backtrack(int nums[],List<Integer>current,List<List<Integer>>result){
        if(current.size()==nums.length){ //if the current list has all elements, add it to the result
            result.add(new ArrayList<>(current)); //Create a new list and add to result
            return;
        }
        for(int num:nums){
            if(current.contains(num)){
                continue; //Skip if the number is already in the current list
            }
            current.add(num); // Choose the current number
            backtrack(nums,current,result); //Explore further with this choice
            current.remove(current.size()-1); //ndo the choice (backtrack)
        }
    }
}
