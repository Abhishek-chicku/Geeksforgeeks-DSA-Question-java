class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        
     int left = 1, right = 0;
        for(int pile : arr)
            right = Math.max(right, pile);
        int res = right; 
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canFinish(arr, k, mid)){
                res = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }

        return res;
    }
    public boolean canFinish(int arr[], int k, int s){
        int hours = 0;
        for(int pile : arr){
            hours += (pile + s - 1) / s;
            if (hours > k) 
                return false;
        }
        return hours <= k;
    }
}