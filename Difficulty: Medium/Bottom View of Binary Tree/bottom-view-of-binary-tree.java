/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    class Pair{
        Node node ; 
        int hd ; 
        Pair(Node node , int hd ){
            this.node = node ; 
            this.hd = hd ; 
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        // RADHE RADHE 
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        
        TreeMap<Integer,Node> map = new TreeMap<>();
        
        while(!q.isEmpty()){
            
            Pair curr = q.poll();
            
            map.put(curr.hd,curr.node);
            
         if(curr.node.left!=null) q.add(new Pair(curr.node.left,curr.hd-1));
         if(curr.node.right!=null) q.add(new Pair(curr.node.right,curr.hd+1));
        
            
        }
        
        for(int ele : map.keySet()){
            ans.add(map.get(ele).data);
        }
        
        return ans ;
    }
} 