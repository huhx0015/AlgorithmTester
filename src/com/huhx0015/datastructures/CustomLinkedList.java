package com.huhx0015.datastructures;

/**
 * Created by Michael Yoon Huh on 5/29/2017.
 */
public class CustomLinkedList {

    private Object data;
    private CustomLinkedList head;
    private CustomLinkedList tail;

    public CustomLinkedList(Object data) {
        this.data = data;
        this.head = null;
        this.tail = null;
    }

    public CustomLinkedList(Object data, CustomLinkedList head, CustomLinkedList tail) {
        this.data = data;
        this.head = head;
        this.tail = tail;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public CustomLinkedList getHead() {
        return head;
    }

    public void setHead(CustomLinkedList head) {
        this.head = head;
    }

    public CustomLinkedList getTail() {
        return tail;
    }

    public void setTail(CustomLinkedList tail) {
        this.tail = tail;
    }
}
