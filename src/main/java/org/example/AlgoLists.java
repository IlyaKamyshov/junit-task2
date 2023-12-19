package org.example;

import java.io.*;

public class AlgoLists {

    public static void main(String[] args) throws IOException {
        LinkedStack stack = new LinkedStack();

        System.out.println(stack); // EMPTY

        stack.push(5);
        System.out.println(stack); // 5

        stack.push(15);
        System.out.println(stack); // 15 -> 5

        stack.push(25);
        System.out.println(stack); // 25 -> 15 -> 5

        System.out.println(stack.pop()); // 25
        System.out.println(stack); // 15 -> 5

        System.out.println(stack.pop()); // 15
        System.out.println(stack); // 5

        System.out.println(stack.pop()); // 5
        System.out.println(stack); // EMPTY
    }

}

class LinkedStack {
    private Node tail; // ссылка на последний добавленный узел (обёртку)
    private int size; // размер стека, т.е. количество элементов в нём

    public void push(int value) {
        Node node = new Node(value); // создаём новый узел
        if (tail != null) { // если в стеке уже есть элементы
            node.setPrev(tail); // связываем новый узел с последним
        }
        tail = node; // назначаем новый узел последним узлом
        size++; // увеличиваем счётчик элементов
    }

    public int pop() {
        // ваш код
        // возьмите value из последнего узла
        // назначьте предыдущий к последнему узлу последним узлом
        int tmp = tail.getValue();
        tail = tail.getPrev();
        return tmp;
    }

    public int getSize() {
        // ваш код
        // верните размер стека
        return size;
    }

    public boolean isEmpty() {
        // ваш код
        // верните ответ на вопрос, не пустой ли стек
        return size == 0;
    }

    public String toString() {
        // если есть элементы, пройдитесь по связному списку,
        // выводя элементы.
        // вывод должен быть в точности как в комментариях к main
        // при этом этот метод не должен менять стек!
        Node current = tail;
        StringBuilder tmp = new StringBuilder();
        if (current == null) {
            return "EMPTY";
        }
        while (current != null) {
            tmp.append(String.valueOf(current.getValue()));
            current = current.getPrev();
            if (current != null) {
                tmp.append(" -> ");
            }
        }
        return tmp.toString();
    }

}

class Node {
    private int value;
    private Node prev; // ссылка на обёртку предыдущего элемента

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getPrev() {
        return prev;
    }

    /** Связывание узла с предыдущим, т.е. выставление узлу какой узел является к нему предыдущим */
    public void setPrev(Node prev) {
        this.prev = prev;
    }
}



