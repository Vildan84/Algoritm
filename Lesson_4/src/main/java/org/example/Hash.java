package org.example;

public class Hash<Key, Value> {

    private static final double loadFactor = 0.75;
    private static int size = 16;
    private Basket[] baskets;

    public Hash(){
        this(size);
    }

    public Hash(int size){
        baskets = (Basket[]) new Object[size];
    }

    private class Entity{
        private Key key;
        private Value value;
    }

    private int getIndex(Key key){
        return Math.abs(key.hashCode() % baskets.length);
    }

    public Value get(Key key){
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket != null){
            return basket.getValue(key);
        }
        return null;
    }

    public boolean put(Key key, Value value){
        if (baskets.length * loadFactor < size){
            reload();
        }
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket == null){
            basket = new Basket();
            baskets[index] = basket;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;

        if (basket.add(entity)){
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(Key key){
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket.remove(key)){
            size--;
            return true;
        }
        return false;
    }

    public void reload(){
        Basket[] old = baskets;
        baskets = (Basket[]) new Object[old.length * 2];
        for (int i = 0; i < old.length; i++){
            Basket basket = old[i];
            Basket.Node node = basket.head;
            while(node != null){
                put(node.entity.key, node.entity.value);
                node = node.next;
            }
            old[i] = null;
        }
    }

    private class Basket{
        private Node head;

        private class Node{
            private Node next;
            private Entity entity;
        }

        private Value getValue(Key key){
            Node node = head;
            while (node != null){
                if (node.entity.key.equals(key)){
                    return node.entity.value;
                }
                node = node.next;
            }
            return null;
        }

        public boolean add(Entity entity){
            Node node = new Node();
            node.entity = entity;
            if (head == null){
                head = node;
                return true;
            }
            else{
                Node currNode = head;
                while(currNode.next != null){
                    if (currNode.entity.key.equals(entity.key)){
                        return false;
                    }
                    currNode = currNode.next;

                }
                currNode.next = node;
                return true;
            }
        }

        public boolean remove(Key key){
            if (head != null){
                if (head.entity.key.equals(key)){
                    head = head.next;
                }
                Node currNode = head;
                while (currNode.next != null){
                    if (currNode.next.entity.key.equals(key)){
                        currNode.next = currNode.next.next;
                        return true;
                    }
                    currNode = currNode.next;
                }
            }
            return false;
        }
    }

}
