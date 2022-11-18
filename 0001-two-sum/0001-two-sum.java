class Solution {
    public int[] twoSum(int[] arr, int t) {
        int n = arr.length;
        int res[] = new int[2];
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n ;i++){
            if(hm.containsKey(t - arr[i])){
                res[0] =hm.get(t-arr[i]);;
                res[1]= i;
            }
            hm.put(arr[i],i );
        }
        return res;
    }
}