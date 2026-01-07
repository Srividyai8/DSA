STACK APPLICATIONS

import java.util.*;

class StackElements {

    // Next Greater Element (Right)
    public static int[] nge(int[] arr, int n) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }
        return res;
    }

    // Next Smaller Element (Right)
    public static int[] nse(int[] arr, int n) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }
        return res;
    }

    // Previous Greater Element (Left)
    public static int[] pge(int[] arr, int n) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) res[i] = arr[st.peek()];
            st.push(i);
        }
        return res;
    }

    // Previous Smaller Element (Left)
    public static int[] pse(int[] arr, int n) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) res[i] = arr[st.peek()];
            st.push(i);
        }
        return res;
    }

    // Main function
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int n = arr.length;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("NGE: " + Arrays.toString(nge(arr, n)));
        System.out.println("NSE: " + Arrays.toString(nse(arr, n)));
        System.out.println("PGE: " + Arrays.toString(pge(arr, n)));
        System.out.println("PSE: " + Arrays.toString(pse(arr, n)));
    }
}
