package com.vic.algorithm.tree;

public class RotateTest {
	// Red-black mechanics

    private static final boolean RED   = false;
    private static final boolean BLACK = true;
    private transient Entry root;
    
    static final class Entry {
    	Entry left;
    	Entry right;
    	Entry parent;
    	boolean color = BLACK;
    }
    
    void rotateLeft(Entry p) {
    	Entry r = p.right;
    	p.right = r.left;
    	if(r.left != null)
    		r.left.parent = p;
    	r.parent = p.parent;
    	if(p.parent == null)
    		root = r;
    	else if(p.parent.left == p)
    		p.parent.left = r;
    	else p.parent.right = r;
    	r.left = p;
    	p.parent = r;
    }
    
    void rotateRight(Entry p) {
    	Entry l = p.left;
    	p.left = l.right;
    	if(l.right != null)
    		l.right.parent = p;
    	l.parent = p.parent;
    	if(p.parent == null)
    		root = l;
    	else if(p.parent.right == p)
    		p.parent.right = l;
    	else p.parent.left = l;
    	l.right = p;
    	p.parent = l;
    }
}

