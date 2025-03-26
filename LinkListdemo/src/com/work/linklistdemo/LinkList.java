package com.work.linklistdemo;

import javax.xml.soap.Node;

public class LinkList<T> {

    private Node head;

    private int N;


    private class Node {
        T item;
        Node next;
        public Node (T item,Node next){
            this.item = item;
            this.next = next;
        }
    }//链表节点 item表示节点的值，next表示下一个节点

    public LinkList(){
        this.head = new Node(null,null);//初始化头节点
        this.N = 0;//初始化元素个数
    }//构造函数

    public void clear(){
        this.head.next = null;
        this.N = 0;
    }//清空链表

    public int length(){
        return this.N;
    }//获取链表长度

    public boolean isEmpty(){
        return this.length() == 0;
    }//判断链表是否为空

    public void insert(T t){
        Node p = this.head;
        while(p.next != null){
            p = p.next;
        }
        Node newNode = new Node(t,null);
        p.next = newNode;
        this.N++;
    }//在链表最后插入t

    public void insert(T t,int index){
        if(index < 0 || index > this.N){
            throw new RuntimeException("index不合法");
        }
        Node p = this.head;
        for(int i = 0;i < index;i++){
            p = p.next;
            if(p == null){
                throw new RuntimeException("index不合法");
            }
            if(p.next == null){
                Node newNode = new Node(t,null);
                p.next = newNode;
                this.N++;
            }
            if(p.next != null){
                Node newNode = new Node(t,p.next);
                p.next = newNode;
                this.N++;
            }
        }

    }//在index位置插入t

    public T get(int index){
        if(index < 0 || index > this.N){
            throw new RuntimeException("index不合法");
        }
        Node p = this.head.next;
        for(int i = 0;i < index;i++){
            p = p.next;
        }
        return p.item;
    }//获取index位置的元素
}
