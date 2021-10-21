package com.vic.datastructure.binarytree;

/**
 * 二叉树结点
 * @author luolihua
 */
public class BinNode {

    public BinNode(String data) {
        this.data = data;
    }

    /**
     * 结点的数据域
     */
    String data;

    /**
     * 左子树
     */
    BinNode leftSubtree;

    /**
     * 右子树
     */
    BinNode rightSubtree;



}
