PRIORITY QUEUE APPLICATIONS


// Running Median
import java.util.*;

class RunningMedian {

    static PriorityQueue<Integer> maxHeap = 
        new PriorityQueue<>(Collections.reverseOrder()); // left

    static PriorityQueue<Integer> minHeap = 
        new PriorityQueue<>(); // right

    // Add number to heaps
    public static void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // Balance heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    // Get median
    public static double getMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }

    // Main
    public static void main(String[] args) {
        int[] stream = {5, 15, 1, 3};

        for (int num : stream) {
            addNum(num);
            System.out.println("Inserted: " + num +
                    " | Median: " + getMedian());
        }
    }
}




// Min cost to make long chain

import java.util.*;

class BeingZero {

    public int minCostLongChain(List<Integer> arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add all elements to min heap
        for (int x : arr) {
            pq.add(x);
        }

        int cost = 0;

        // combine until one chain remains
        while (pq.size() > 1) {
            int x = pq.remove();
            int y = pq.remove();
            int sum = x + y;

            cost += sum;
            pq.add(sum);
        }

        return cost;
    }

    // main function for testing
    public static void main(String[] args) {
        BeingZero obj = new BeingZero();

        List<Integer> arr = Arrays.asList(4, 3, 2, 6);
        System.out.println(obj.minCostLongChain(arr));
    }
}
