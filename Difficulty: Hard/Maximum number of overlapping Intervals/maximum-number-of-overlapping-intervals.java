
class Solution {
    public static int overlapInt(int[][] arr) {
        // code here
                int max=0,ans=0;

        for(int[]a:arr)

        max=Math.max(max,a[1]);       

        

    

    int[]pre=new int[max+5];

    for(int[]it:arr){

        pre[it[0]]++;

        pre[it[1]+1]--;

    }

    for(int i=1;i<pre.length;i++){

        pre[i]=pre[i]+pre[i-1];

        ans=Math.max(ans,pre[i]);

    }

    return ans;


    }
}
