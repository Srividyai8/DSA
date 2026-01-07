SET
import java.util.*;

public class SetDistinct {

    // 1. Get unique elements (removes duplicates)
    static Set<Integer> getUniqueElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        return set;
    }

    // 2. Count number of distinct elements
    static int countDistinct(Set<Integer> set) {
        return set.size();
    }

    // 3. Search an element
    static boolean searchElement(Set<Integer> set, int key) {
        return set.contains(key);
    }

    // 4. Sort elements
    static Set<Integer> sortElements(Set<Integer> set) {
        return new TreeSet<>(set);
    }

    public static void main(String[] args) {

        int[] numbers = {5, 2, 8, 2, 5, 10, 8, 3};

        // Get unique elements
        Set<Integer> uniqueSet = getUniqueElements(numbers);
        System.out.println("Unique elements: " + uniqueSet);

        // Count distinct elements
        System.out.println("Count of distinct elements: " 
                            + countDistinct(uniqueSet));

        // Search
        int search = 8;
        if (searchElement(uniqueSet, search)) {
            System.out.println(search + " is found");
        } else {
            System.out.println(search + " is not found");
        }

        // Sort
        Set<Integer> sortedSet = sortElements(uniqueSet);
        System.out.println("Sorted elements: " + sortedSet);
    }
}





MAP 
import java.util.*;
public class MapDistinct {
    // 1. Create frequency map
    static Map<Integer, Integer> buildFrequencyMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    // 2. Count number of distinct elements
    static int countDistinctElements(Map<Integer, Integer> map) {
        return map.size();
    }
    // 3. Display key–value pairs
    static void displayMap(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // 4. Search an element
    static void searchElement(Map<Integer, Integer> map, int key) {
        if (map.containsKey(key)) {
            System.out.println(key + " found with count = " + map.get(key));
        } else {
            System.out.println(key + " not found");
        }
    }
    // 5. Find duplicate elements
    static void findDuplicates(Map<Integer, Integer> map) {
        System.out.println("Duplicate elements:");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " occurs " + entry.getValue() + " times");
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 2, 5, 10, 8, 3};
        Map<Integer, Integer> freqMap = buildFrequencyMap(numbers);
        System.out.println("Key–Value pairs:");
        displayMap(freqMap);
        System.out.println("Count of distinct elements: " 
                            + countDistinctElements(freqMap));
        searchElement(freqMap, 8)
        findDuplicates(freqMap);
    }
}




BIT MANIPULATION
import java.util.*;

class BeingZero {

    /* ---------------------------------------------------
       1️⃣ FIND AKELA (Element appearing once, others twice)
       --------------------------------------------------- */
    public static int findAkela(int[] a) {
        int ans = 0;
        for (int x : a) {
            ans ^= x;
        }
        return ans;
    }

    /* ---------------------------------------------------
       2️⃣ SET kth BIT
       --------------------------------------------------- */
    public static long setBit(long n, int k) {
        return n | (1L << k);
    }

    /* ---------------------------------------------------
       3️⃣ CLEAR kth BIT
       --------------------------------------------------- */
    public static long clearBit(long n, int k) {
        return n & ~(1L << k);
    }

    /* ---------------------------------------------------
       4️⃣ FLIP kth BIT
       --------------------------------------------------- */
    public static long flipBit(long n, int k) {
        return n ^ (1L << k);
    }

    /* ---------------------------------------------------
       5️⃣ CHECK kth BIT
       --------------------------------------------------- */
    public static boolean checkBit(long n, int k) {
        return (n & (1L << k)) != 0;
    }

    /* ---------------------------------------------------
       6️⃣ FIND MISSING & REPEATED NUMBER (1..n)
       --------------------------------------------------- */
    public static int[] findMissingAndRepeated(int[] a, int n) {

        int xor = 0;
        for (int i = 0; i < n; i++)
            xor ^= a[i];

        for (int i = 1; i <= n; i++)
            xor ^= i;

        int rsb = xor & -xor;

        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            if ((a[i] & rsb) != 0) x ^= a[i];
            else y ^= a[i];
        }

        for (int i = 1; i <= n; i++) {
            if ((i & rsb) != 0) x ^= i;
            else y ^= i;
        }

        for (int num : a) {
            if (num == x)
                return new int[]{x, y}; // repeated, missing
        }
        return new int[]{y, x};
    }

    /* ---------------------------------------------------
       7️⃣ TRIPLE TROUBLE
       (One element appears once, others thrice)
       --------------------------------------------------- */
    public static int tripleTrouble(int[] a) {
        int ones = 0, twos = 0;
        for (int num : a) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }

    /* ---------------------------------------------------
       8️⃣ POWER CHECKS (Bit Manipulation)
       --------------------------------------------------- */

    // Power of 2
    public static boolean isPowerOf2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // Power of 4
    public static boolean isPowerOf4(int n) {
        return isPowerOf2(n) && (n & 0x55555555) != 0;
    }

    // Power of 8
    public static boolean isPowerOf8(int n) {
        return isPowerOf2(n) && (n % 7 == 1);
    }

    // Power of 16
    public static boolean isPowerOf16(int n) {
        return isPowerOf2(n) && (n & 0x11111111) != 0;
    }

    /* ---------------------------------------------------
       MAIN (Testing)
       --------------------------------------------------- */
    public static void main(String[] args) {

        // Akela
        int[] akelaArr = {2, 3, 5, 3, 2};
        System.out.println("Akela: " + findAkela(akelaArr));

        // Bit operations
        long n = 10;
        int k = 1;
        System.out.println("Set Bit: " + setBit(n, k));
        System.out.println("Clear Bit: " + clearBit(n, k));
        System.out.println("Flip Bit: " + flipBit(n, k));
        System.out.println("Check Bit: " + checkBit(n, k));

        // Missing & Repeated
        int[] mr = {1, 3, 3, 4, 5};
        int[] res = findMissingAndRepeated(mr, 5);
        System.out.println("Repeated: " + res[0] + " Missing: " + res[1]);

        // Triple Trouble
        int[] triple = {6, 1, 3, 3, 3, 6, 6};
        System.out.println("Triple Trouble Answer: " + tripleTrouble(triple));

        // Power checks
        int num = 16;
        System.out.println("Power of 2: " + isPowerOf2(num));
        System.out.println("Power of 4: " + isPowerOf4(num));
        System.out.println("Power of 8: " + isPowerOf8(num));
        System.out.println("Power of 16: " + isPowerOf16(num));
    }
}


}
