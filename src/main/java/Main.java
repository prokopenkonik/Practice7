import util.RedBlackTree;

import java.util.Arrays;

public class Main {

    private static final int SIZE = 10;

    public static void main(String[] args) {
        int[] randomInts = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            randomInts[i] = (int)(Math.random() * 100);
        }
        RedBlackTree<Integer> rbt1 = new RedBlackTree<Integer>();
        System.out.println(Arrays.toString(randomInts));
        for (int i = 0; i < SIZE; i++) {
            rbt1.add(randomInts[i]);
        }
        rbt1.show();
        System.out.println();
        rbt1.showFromMinToMax();


        Arrays.sort(randomInts);
        System.out.println(Arrays.toString(randomInts));
        RedBlackTree<Integer> rbt2 = new RedBlackTree<Integer>();
        for (int i = 0; i < SIZE; i++) {
            rbt2.add(randomInts[i]);
        }
        rbt2.show();
        System.out.println();
        rbt2.showFromMinToMax();
    }
}
