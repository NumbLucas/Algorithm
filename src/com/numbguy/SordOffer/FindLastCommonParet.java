package com.numbguy.SordOffer;

import com.numbguy.Structure.Student;
import com.numbguy.Structure.TreeNode;

import java.util.*;

public class FindLastCommonParet {



    public static boolean getPath(TreeNode root, TreeNode target, ArrayList<TreeNode> path) {
        if(root == null)
            return false;
        if(root == target){
            path.add(root);
            return  true;
        }

        boolean left_rst = false;
        boolean right_rst = false;

        path.add(root);
        if(root.left != null)
            left_rst = getPath(root.left, target, path);
        if(root.right != null)
            right_rst = getPath(root.right, target, path);

        if(left_rst||right_rst)
            return true;
        path.remove(path.size() -1);
        return false;
    }

    public static TreeNode findFirstCommonNode(ArrayList<TreeNode> path1, ArrayList<TreeNode> path2) {
        TreeNode lastCommonParent = null;

        int i = 0;
        int j = 0;

        while(i < path1.size()&&j < path2.size()) {
            if(path1.get(i) == path2.get(j))
                lastCommonParent = path1.get(i);
            i++;
            j++;
        }

        return lastCommonParent;
    }

    public static TreeNode buildTree(char[] s, TreeNode t1, TreeNode t2, int index) {
        if(index >= s.length)
            return null;
        int left = 2*index + 1;
        int right = 2*index +2;

        TreeNode root = new TreeNode(s[index]);

        if(s[index] == (char)t1.value)
            root = t1;
        else if(s[index] == (char)t2.value)
            root = t2;


        if(left < s.length)
            root.left = buildTree(s, t1, t2, left);

        if(right < s.length)
            root.right = buildTree(s, t1, t2, right);

        return root;

    }

    public static void main(String[] args) {
        TreeNode root = null;
        TreeNode t1 = new TreeNode('h');
        TreeNode t2 = new TreeNode('j');
        String treeChar = "abcdefghijkl";
        root = buildTree(treeChar.toCharArray(),  t1, t2, 0);

        //levelOrderTree(root);
        //midOrder(root);
        //preOrder(root);
        //postOrder(root);
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        getPath(root, t1, path1);
        getPath(root, t2, path2);
        //printArrayLIst(path1);


        System.out.println(findFirstCommonNode(path1, path2));;
    }

    public static void levelOrderTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.push(root);
        while(!q.isEmpty()) {
            TreeNode current = q.poll();
            System.out.println(current.value);

            if(current.left != null)
                q.offer(current.left);
            if(current.right != null)
                q.offer(current.right);
        }
    }

    public static void preOrder(TreeNode root) {

        if(root != null) {
            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);

        }
    }

    public static void midOrder(TreeNode root) {

        if(root != null) {
            midOrder(root.left);
            System.out.println(root.value);
            midOrder(root.right);
        }
    }

    public static void postOrder(TreeNode root) {

        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.value);

        }
    }

    public static void test(TreeNode root, ArrayList s) {
        root.value = 'x';
        s.add(root.value);
    }

    public static void testStudent(Student s) {
        s = new Student("t", 10);
    }

    public static void printArrayLIst(ArrayList array) {
        for(int i = 0; i < array.size();i++) {
            System.out.println(array.get(i));
        }
    }
}
