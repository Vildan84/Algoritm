package org.example;

public class OneWayLinked {

    Node head;

    public class Node{
        Integer value;
        Node nextNode;
    }

    public void push(Integer value){
        Node node = new Node();
        node.value = value;
        node.nextNode = head;
        head = node;
    }

    public void print(){
        Node node = head;
        while (node != null){
            System.out.println(node.value);
            node = node.nextNode;
        }
    }

    public void revert(){
        Node node = head;
        Node current = null;
        Node next = node;

        while(node != null){
            next = node.nextNode;
            node.nextNode = current;
            current = node;
            if (next == null){
                head = node;
            }
            node = next;
        }
    }
}
