class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int n = arr.length-1;
         for(int i=0; i<; i++){
            if(arr[i]>arr[i+1]){
                return i+1;
            }
        }
        return 0;
    }
}