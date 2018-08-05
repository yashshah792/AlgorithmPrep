import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Traversals{
    //Recursive
    public void PreOrder(BinaryTreeNode root){
        if(root != null){
            System.out.println(root.data);
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }

    //Iterative
    public ArrayList<Integer> preOrderTraversal(BinaryTreeNode root){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        s.push(root);
        while(!s.isEmpty()){
            BinaryTreeNode tmp = s.pop();
            res.add(tmp.data);
            if(tmp.right != null){
                s.push(tmp.right);
            }
            if(tmp.left != null){
                s.push(tmp.left);
            }
        }
        return res;
    }

    //Recursive
    public void InOrder(BinaryTreeNode root){
        if(root != null){
            InOrder(root.left);
            System.out.println(root.data);
            InOrder(root.right);
        }
    }

    //Iterative
    public ArrayList<Integer> inOrderTraversal(BinaryTreeNode root){
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        BinaryTreeNode currentNode = root;
        boolean done = false;
        while(!done){
            if(currentNode !=  null){
                s.push(currentNode);
                currentNode = currentNode.left;
            }else{
                if(s.isEmpty()){
                    done = true;
                }else{
                    currentNode = s.pop();
                    res.add(currentNode.data);
                    currentNode = currentNode.right;
                }
            }
        }
        return res;
    }

    //Recursive
    public void PostOrder(BinaryTreeNode root){
        if(root != null){
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.println(root.data);
        }
    }

    //Iterative
    public ArrayList<Integer> postOrderTraversal(BinaryTreeNode root){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        s.push(root);
        BinaryTreeNode prev = null;
        while(!s.isEmpty()){
            BinaryTreeNode curr = s.peek();
            if(prev == null || prev.left == curr || prev.right == curr){
                if(curr.left != null){
                    s.push(curr.left);
                }else if(curr.right != null){
                    s.push(curr.right);
                }else if(curr.right == prev){
                    if(curr.right != null){
                        s.push(curr.right);
                    }else{
                        res.add(curr.data);
                        s.pop();
                    }
                    prev = curr;
                }
            }
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> levelOrderTraversal(BinaryTreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null);
        ArrayList<Integer> curr = new ArrayList<Integer>();
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            if(tmp != null){
                curr.add(tmp.data);
                if(tmp.left != null){
                    q.offer(tmp.left);
                }
                if(tmp.right != null){
                    q.offer(tmp.right);
                }
            }else{
                ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);
                res.add(c_curr);
                curr.clear();
                if(!q.isEmpty()){
                    q.offer(null);
                }
            }
        }

        return res;
    }
}