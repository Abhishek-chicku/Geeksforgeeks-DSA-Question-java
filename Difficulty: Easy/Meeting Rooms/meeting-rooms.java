class Solution {
    static boolean canAttend(int[][] arr) {
        // code here
          int n = arr.length;
        Arrays.sort(arr , (a , b)->{
            if(a[0] != b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1] , b[1]);
        });
        
        for(int i = 1 ; i < n ; i++){
            if(arr[i][0] < arr[i-1][1]){
                return false;
            }
        }
        
        return true;
    }
}