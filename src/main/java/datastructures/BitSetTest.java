package datastructures;

import java.util.BitSet;

public class BitSetTest {
    public static void main(String... args) {
        BitSet bitSet = new BitSet(3);
        bitSet.set(0);
        bitSet.set(2);
        System.out.println(bitSet);
    }
}

