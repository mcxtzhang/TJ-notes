package com.mcxtzhang;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    Node<T> head;

    public Node<T> getHead() {
        return head;
    }

    public boolean isEnd() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void push(T value) {
        Node<T> newNode = new Node<>();
        newNode.value = value;
        newNode.next = head;
        head = newNode;
    }

    public void add(T value) {

        if (head == null) {
            head = new Node<>();
            head.value = value;
            head.next = null;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<>();
            temp.next.value = value;
            temp.next.next = null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> traveselHead;

            {
                traveselHead = head;
            }


            public boolean isEnd() {
                if (traveselHead == null) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public boolean hasNext() {
                return !isEnd();
            }

            @Override
            public T next() {

                T value = traveselHead.value;
                traveselHead = traveselHead.next;
                return value;
            }
        };
    }

    public class Node<T> {
        public T value;
        public Node<T> next;
    }


}