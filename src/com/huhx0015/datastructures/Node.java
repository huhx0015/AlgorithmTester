package com.huhx0015.datastructures;

/**
 * Created by Michael Yoon Huh on 4/7/2017.
 */
public class Node {

    public String name;
    public int value;

    public Node left;
    public Node right;

    public Node[] children;
    public Node[] adjacent;

    public boolean visited = false;
    public boolean marked = false;

    public Node(String name) {
        this.name = name;
    }

    public Node(int value) {
        this.value = value;
    }

//    public Node(String name, Node[] children) {
//        this.name = name;
//        this.children = children;
//    }

    public Node(String name, Node[] adjacent) {
        this.name = name;
        this.adjacent = adjacent;
    }
}
