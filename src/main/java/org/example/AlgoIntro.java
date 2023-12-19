package org.example;

public class AlgoIntro {

    public static void main(String[] args) {
        int[] prices = {13, 17, 19, 25, 25, 25, 25, 25, 25, 27, 30};

        System.out.println("��� 31: " + countMore(prices, 31)); // 0
        System.out.println("��� 26: " + countMore(prices, 26)); // 2
        System.out.println("��� 25: " + countMore(prices, 25)); // 2*/
        System.out.println("��� 20: " + countMore(prices, 20)); // 8
    }

    public static int countMore(int[] prices, int money) {
        if (prices[0] > money) {
            return prices.length; // ��� ����������
        }

        if (prices[prices.length - 1] < money) {
            return 0; // ��� ��������
        }

        int left = 0;
        int right = prices.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            // ��� ���:
            // ���� � middle ������ ����������� �����, ������� ������ ������� ����� middle
            if (prices[middle] > money && prices[middle-1] <= money) {
                return prices.length - middle;
            }
            // ���� � middle ��������� �����, �� ������ ����� ������ - left = middle + 1
            if (prices[middle] <= money) {
                left = middle + 1;
            }
            // ���� � middle ����������� �����, �� ������ ����� ����� - right = middle - 1
            if (prices[middle] > money) {
                right = middle - 1;
            }
        }
        return 0; // ����� �� �����������, ����� ���� �� ����� ��������
    }
}


