package org.example;

public class Linked {
    private Node head;
    private Node tail;

    class Node{
        private int value;
        private Node nextNode;
        private Node previousNode;
    }

    public Node findNode(int value){
        Node node = head;
        while (node != null){
            if (node.value == value){
                return node;
            }
            node = node.nextNode;
        }
        return null;
    }

    public void addLast(int value){
        Node node = new Node();
        node.value = value;

        if (head == null){
            head = node;
        }
        else {
            tail.nextNode = node;
            node.previousNode = tail;
        }
        tail = node;
    }

    public void add(int value, Node node){
        Node next = node.nextNode;
        Node newNode = new Node();
        newNode.value = value;
        node.nextNode = newNode;
        newNode.previousNode = node;

        if (tail == null){
            tail = newNode;
        }
        else{
            next.previousNode = newNode;
            newNode.nextNode = next;
        }
    }

    public void delete (Node node){
        Node previous = node.previousNode;
        Node next = node.nextNode;
        if (previous == null){
            next.previousNode = null;
            head = next;
        }
        else{
            if (next == null){
                previous.nextNode = null;
                tail = previous;
            }
            else{
                previous.nextNode = next;
                next.previousNode = previous;
            }
        }
    }

    public void revert(){
        Node currNode = head;
        while (currNode != null){
            Node next = currNode.nextNode;
            Node previous = currNode.previousNode;
            currNode.nextNode = previous;
            currNode.previousNode = next;
            if (previous == null){
                tail = currNode;
            }
            if (next == null){
                head = currNode;
            }
            currNode = next;
        }
    }

    public void push(int value){
        Node newNode = new Node();
        newNode.value = value;
        newNode.nextNode = head;
        head = newNode;
    }

    public Integer pop(){
        Integer result = null;
        if (head != null){
            result = head.value;
            head = head.nextNode;
        }
        return result;
    }

    public void print(){
        Node node = head;
        while (node != null){
            System.out.println(node.value);
            node = node.nextNode;
        }
    }

    public void bubbleSort(){
        boolean flag = true;

        while(flag){
            Node node = head;
            flag = false;
            while(node.nextNode != null){
                if (node.value > node.nextNode.value){
                    int temp = node.value;
                    node.value = node.nextNode.value;
                    node.nextNode.value = temp;
                    flag = true;
                }
                node = node.nextNode;
            }
        }
    }
}
