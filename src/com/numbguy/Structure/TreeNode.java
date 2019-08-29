package com.numbguy.Structure;

import java.util.LinkedList;

public class TreeNode{
    public Object value;
    public TreeNode left = null;
    public TreeNode right = null;

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }

    public TreeNode(){}
    public TreeNode(Object value) {
        this.value = value;
    }

    public void setValue(char v) {
        value = v;
    }

    public void preOrder(TreeNode root) {
        if(root != null) {
            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void midOrder(TreeNode root) {
        if(root != null) {
            midOrder(root);
            System.out.println(root.value);
            midOrder(root);
        }
    }

    public void postOrder(TreeNode root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.value);
        }
    }

    public void levelOrder(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode current = q.poll();
            System.out.println(current.value);
            if(current.left != null)
                q.offer(current.left);
            if(current.right != null)
                q.offer(current.right);
        }
    }
}
