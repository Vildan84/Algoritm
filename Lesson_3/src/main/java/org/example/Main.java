package org.example;



public class Main {
    public static void main(String[] args) {

//        OneWayLinked one = new OneWayLinked();
//        one.push(1);
//        one.push(2);
//        one.push(3);
//        one.push(4);
//        one.print();
//        System.out.println("/////////////////////////");
//        one.revert();
//        one.print();

        TwoWayLinked two = new TwoWayLinked();
        two.addLast(1);
        two.addLast(2);
        two.addLast(3);
        two.addLast(4);
        two.print();
        System.out.println("//////////////////////////");
        two.revert();
        two.print();






    }
}