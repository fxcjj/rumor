package com.vic.datastructure.binarytree;

import java.util.Stack;

/**
 * @author luolihua
 */
public class TraversalTest {

    public static void main(String[] args) {

        BinNode nodeB = new BinNode("B");
        BinNode nodeC = new BinNode("C");
        BinNode nodeD = new BinNode("D");
        BinNode nodeE = new BinNode("E");
        BinNode nodeF = new BinNode("F");

        // root结点
        BinNode root = new BinNode("A");
        root.leftSubtree = nodeB;
        root.rightSubtree = nodeC;

        nodeB.leftSubtree = nodeD;
        nodeB.rightSubtree = nodeE;

        nodeC.rightSubtree = nodeF;

        /*
        递归三步曲
        1. 递归函数的参数和返回值
        2. 确定终止条件
        3. 单层循环的逻辑
         */

        // 1 递归方式遍历
        // 1.1 前序遍历
//        System.out.print("前序遍历：");
//        preOrder(root);
//        System.out.println();

        // 1.2 中序遍历
//        System.out.print("中序遍历：");
//        inOrder(root);
//        System.out.println();

        // 1.3 后序遍历
//        System.out.print("后序遍历：");
//        postOrder(root);
//        System.out.println();


        // 2 非递归方式遍历
        // 2.1 非递归前序遍历
        System.out.print("非递归前序遍历：");
        nonRecPreOrder(root);
        System.out.println();

        // 2.2 非递归中序遍历
        System.out.print("非递归中序遍历：");
        nonRecInOrder(root);
        System.out.println();

        // 2.3 非递归后序遍历
        System.out.print("非递归后序遍历：");
        nonRecPostOrder(root);
        System.out.println();

        // 3 二叉树的深度
        System.out.println("树的高度：" + height(root));

        // 4 树的节点数
        System.out.println("树的节点数：" + size(root));

    }

    /**
     * 前序遍历
     * @param node
     */
    private static void preOrder(BinNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.leftSubtree);
        preOrder(node.rightSubtree);
    }

    /**
     * 中序遍历
     * @param node
     */
    private static void inOrder(BinNode node) {
        if(node == null) {
            return;
        }
        inOrder(node.leftSubtree);
        System.out.print(node.data + " ");
        inOrder(node.rightSubtree);
    }

    /**
     * 后序遍历
     * @param node
     */
    private static void postOrder(BinNode node) {
        if(node == null) {
            return;
        }
        postOrder(node.leftSubtree);
        postOrder(node.rightSubtree);
        System.out.print(node.data + " ");
    }


    /**
     * 非递归前序遍历
     * @param node
     */
    private static void nonRecPreOrder(BinNode node) {
        Stack<BinNode> stack = new Stack<>();
        BinNode pNode = node;
        while (pNode != null || stack.size() > 0) {
            while (pNode != null) {
                System.out.print(pNode.data + " ");
                stack.push(pNode);
                pNode = pNode.leftSubtree;
            }
            if (stack.size() > 0) {
                pNode = stack.pop();
                pNode = pNode.rightSubtree;
            }
        }
    }

    /**
     * 非递归中序遍历
     * @param node
     */
    private static void nonRecInOrder(BinNode node) {
        Stack<BinNode> stack = new Stack<>();
        BinNode pNode = node;
        while (pNode != null || stack.size() > 0) {
            while (pNode != null) {
                stack.push(pNode);
                pNode = pNode.leftSubtree;
            }
            if (stack.size() > 0) {
                pNode = stack.pop();
                System.out.print(pNode.data + " ");
                pNode = pNode.rightSubtree;
            }
        }
    }

    /**
     * 非递归后序遍历
     * @param pNode
     */
    private static void nonRecPostOrder(BinNode pNode) {
        Stack<BinNode> stack = new Stack<>();
        BinNode node = pNode;
        while (pNode != null) {
            // 左子树入栈
            while (pNode.leftSubtree != null) {
                stack.push(pNode);
                pNode = pNode.leftSubtree;
            }
            // 当前节点无右子树或者右子树已输出
            while (pNode != null && (pNode.rightSubtree == null || pNode.rightSubtree == node)) {
                System.out.print(pNode.data + " ");
                // 记录上一个已输出的节点
                node = pNode;
                if (!stack.isEmpty()) {
                    pNode = stack.pop();
                } else {
                    return;
                }
            }
            //右子树入栈
            stack.push(pNode);
            pNode = pNode.rightSubtree;
        }
    }

    /**
     * 计算树的高度
     */
    private static int height(BinNode node) {
        if (node == null) {
            return 0;
        } else {
            int i = height(node.leftSubtree);
            int j = height(node.rightSubtree);
            return (i < j) ? j + 1 : i + 1;
        }
    }

    /**
     * 计算树的节点数
     * @param node
     * @return 树的节点数
     */
    private static int size(BinNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.leftSubtree) + size(node.rightSubtree);
        }
    }
}
