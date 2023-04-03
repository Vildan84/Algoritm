package org.example;

public class TwoWayLinked {

    Node tail;
    Node head;

    public class Node{
        Integer value;
        Node nextNode;
        Node previousNode;
    }

    public void addLast(Integer value){
        Node node = new Node();
        node.value = value;

        if (head == null){
            head = node;
        }
        else{
            tail.nextNode = node;
            node.previousNode = tail;
            node.nextNode = null;
        }
        tail = node;
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

        while(node != null){
            Node next = node.nextNode;
            Node previous = node.previousNode;
            node.nextNode = previous;
            node.previousNode = next;
            if (previous == null){
                tail = node;
            }
            if (next == null){
                head = node;
            }

            node = next;
        }

    }
}
