QUEUE APPLICATIONS 

//Reduce n to 1
import java.util.*;

class ReduceNtoOne {

    static class Pair {
        int value;
        int steps;

        Pair(int value, int steps) {
            this.value = value;
            this.steps = steps;
        }
    }

    public static int reduceNto1(int n) {
        Queue<Pair> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(new Pair(n, 0));
        visited.add(n);

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            if (cur.value == 1) {
                return cur.steps;
            }

            // n - 1
            if (cur.value - 1 > 0 && !visited.contains(cur.value - 1)) {
                q.add(new Pair(cur.value - 1, cur.steps + 1));
                visited.add(cur.value - 1);
            }

            // n / 2
            if (cur.value % 2 == 0 && !visited.contains(cur.value / 2)) {
                q.add(new Pair(cur.value / 2, cur.steps + 1));
                visited.add(cur.value / 2);
            }

            // n / 3
            if (cur.value % 3 == 0 && !visited.contains(cur.value / 3)) {
                q.add(new Pair(cur.value / 3, cur.steps + 1));
                visited.add(cur.value / 3);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Minimum steps to reduce " + n + " to 1: " + reduceNto1(n));
    }
}





// Burn a Tree


import java.util.*;

class BurnBinaryTree {

    // Tree Node
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Store parent mapping & find target
    public static Node mapParents(Node root, int target, Map<Node, Node> parent) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node targetNode = null;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.data == target)
                targetNode = cur;

            if (cur.left != null) {
                parent.put(cur.left, cur);
                q.add(cur.left);
            }
            if (cur.right != null) {
                parent.put(cur.right, cur);
                q.add(cur.right);
            }
        }
        return targetNode;
    }

    // Burn Tree Function
    public static int burnTree(Node root, int target) {
        Map<Node, Node> parent = new HashMap<>();
        Node targetNode = mapParents(root, target, parent);

        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        q.add(targetNode);
        visited.add(targetNode);

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();

                // left child
                if (cur.left != null && !visited.contains(cur.left)) {
                    visited.add(cur.left);
                    q.add(cur.left);
                    burned = true;
                }

                // right child
                if (cur.right != null && !visited.contains(cur.right)) {
                    visited.add(cur.right);
                    q.add(cur.right);
                    burned = true;
                }

                // parent
                if (parent.containsKey(cur) && !visited.contains(parent.get(cur))) {
                    visited.add(parent.get(cur));
                    q.add(parent.get(cur));
                    burned = true;
                }
            }

            if (burned) time++;
        }
        return time;
    }

    // Main
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int target = 5;
        System.out.println("Time to burn tree: " + burnTree(root, target));
    }
}
