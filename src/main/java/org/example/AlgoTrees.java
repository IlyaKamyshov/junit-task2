package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AlgoTrees {

    public static void main(String[] args) throws IOException {
        // Заполнение дерева
        // Названия переменных указывают на место заполняемого узла
        // например, rl - повернуть на право, затем налево
        // После заполнения дерево выводится на консоль, можете ориентироваться на него


        Tree ll = new Tree("Александа");
        Tree lr = new Tree("Владимир");
        Tree l = new Tree("Борис");
        l.setLeft(ll);
        l.setRight(lr);


        Tree rl = new Tree("Иннокентий");
        Tree rr = new Tree("Пантелеймон");
        Tree r = new Tree("Константин");
        r.setLeft(rl);
        r.setRight(rr);

        Tree root = new Tree("Зоя");
        root.setLeft(l);
        root.setRight(r);

        System.out.println(root); // Выведем дерево в консоль

        System.out.println("Проверка поиска по дереву:");
        System.out.println(root.contains("Иннокентий")); // true
        System.out.println(root.contains("Борис")); // true
        System.out.println(root.contains("Анна")); // false

        // Ваше задание (нужно раскомментировать)
        System.out.println("Проверка на пирамидальность по длине имени:");
        System.out.println(root); // Выведем дерево в консоль
        System.out.println(root.isNamePyramid()); // true

        // Меняем имя в одном из узлов на Павел
        // Пирамидальность должна нарушиться
        // А из-за того что имя на ту же букву,
        // в данном случае свойства дерева поиска сохрнаяются
        rr.setName("Павел");
        System.out.println(root); // Выведем дерево в консоль
        System.out.println(root.isNamePyramid()); // false

    }

}

class Tree {
    private String name;
    private Tree left;
    private Tree right;

    public Tree(String name) {
        this.name = name;
    }

    public boolean contains(String query) {
        if (query.compareTo(name) < 0) {
            return left != null && left.contains(query);
        } else if (query.compareTo(name) > 0) {
            return right != null && right.contains(query);
        } else {
            return name.equals(query);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    // Раскомментируйте и реализуйте этот метод
    public boolean isNamePyramid() {

        if (left == null && right == null) {
            return true;
        }

        if ((left != null && name.length() > left.name.length()) || ((right != null && name.length() > right.name.length()))) {
            return false;
        }

        return (left == null || left.isNamePyramid()) && (right == null || right.isNamePyramid());

    }

    @Override
    public String toString() {
        String[] leftLines = (left != null ? left.toString() : "").split("\n");
        String[] rightLines = (right != null ? right.toString() : "").split("\n");

        int maxLeftSize = Arrays.stream(leftLines)
                .map(String::length)
                .max(Comparator.naturalOrder())
                .orElse(0);

        List<String> lines = new ArrayList<>();
        lines.add(" ".repeat(maxLeftSize + 1) + name);
        for (int i = 0; i < Math.max(leftLines.length, rightLines.length); i++) {
            String prefix = i < leftLines.length ? leftLines[i] : "";
            lines.add(
                    prefix +
                            " ".repeat(maxLeftSize + name.length() + 1 * 2 - prefix.length()) +
                            (i < rightLines.length ? rightLines[i] : "")
            );
        }

        return lines.stream().collect(Collectors.joining("\n"));
    }
}