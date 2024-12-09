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

//one more method
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>permutations=new ArrayList<>();
        backtrack(nums,0,permutations); //recursion start
        return permutations;
    }
    private void backtrack(int[] nums,int start, List<List<Integer>>permutations){
        if(start==nums.length){
            //If we've considered all elements, add the current permutation
            List<Integer>permutation=new ArrayList<>();
            for(int num:nums){
                permutation.add(num);
            }
            permutations.add(permutation);
            return;
        }
        // Recursive case: Try each possibility by swapping elements
        for (int i = start; i < nums.length; i++) {
            // Swap the current element with the start element
            swap(nums, start, i);
            // Recurse with the next element fixed
            backtrack(nums, start + 1, permutations);
            // Backtrack: Undo the swap
            swap(nums, start, i);
        }
    }
    private void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
