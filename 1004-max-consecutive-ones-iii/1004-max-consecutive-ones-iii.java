class Solution {
    public int longestOnes(int[] arr, int k) {
        int start =0, end =0,flip=0, len=0; 
        int n = arr.length;
        while(end<n){
//             Expansion
            if(arr[end]==0)  flip++;
            end++;
            // Contraction Based condition
            while(start<end && flip>k) {
                if(arr[start]==0)flip--;
                start++;
            }
            // Calculation
            len = Math.max(len,  end - start);
        }
        return len;
    }
}