import com.sun.jdi.Value;
import org.w3c.dom.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private Node root;             // root of BST

    private class Node {
        private K key;           // sorted by key
        private V val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(K key, V val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    //constructor
    public BSTMap() {

    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("This key does not exist");
        } else {
            return get(key) != null;
        }
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node root, K key) {
        if (key == null) {
            throw new IllegalArgumentException("This key is null");
        } else if (root == null) {
            return null;
        }
        int cmp = root.key.compareTo(key);
        if (cmp < 0) {
            return get(root.right, key);
        } else if (cmp > 0) {
            return get(root.left, key);
        } else {
            return root.val;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        } else {
            return root.size;
        }
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        } else {
            root = put(root, key, value);
        }
    }


    private Node put(Node root, K key, V val) {
        int cmp = root.key.compareTo(key);
        if (cmp < 0) {
            root.right = put(root.right, key, val);
        } else if (cmp > 0) {
            root.left = put(root.left, key, val);
        } else {
            root.val = val;
        }
        root.size = 1 + size(root.left) + size(root.right);
        return root;
    }

    public void printInOrder() {
        for (int i = 0; i < size(); i++) {
            System.out.println(select(i).key + " " + select(i).val);
        }
    }

    public Node select(int k) {
        if (k < 0 || k > size()) {
            throw new IllegalArgumentException();
        } else {
            return select(k, root);
        }
    }

    public Node select(int k, Node root) {
        if (root == null) {
            return null;
        }
        int t = size(root);
        if (t > k) {
            return select(k, root.left);
        } else if (t < k) {
            return select(k, root.right);
        } else {
            return root;
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (int i = 0; i < size(); i++) {
            set.add(select(i).key);
        }
        return set;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V remove(K key, V value) {
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTIterator(root);
    }

    private class BSTIterator implements Iterator<K> {
        private Stack<BSTMap.Node> stack = new Stack<>();

        public BSTIterator(BSTMap.Node src) {
            while (src != null) {
                stack.push(src);
                src = src.left;
            }
        }

        @Override
        public boolean hasNext() {
            return next() != null;
        }

        @Override
        public K next() {
            BSTMap.Node curr = stack.pop();

            if (curr.right != null) {
                BSTMap.Node temp = curr.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
            return (K) curr.key;
        }
    }
}