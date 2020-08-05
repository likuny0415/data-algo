public class LinkedListDeque<T> {
  int size = 0;
  IntNode sentinel;

  // Build in IntNode
  private class IntNode {
    private T item;
    private IntNode prev;
    private IntNode next;

    public IntNode(IntNode prev,T item,  IntNode next) {
      this.prev = prev;
      this.item = item;
      this.next = next;
    }
  }

  // empty constructor
  public LinkedListDeque() {
    size = 0;
    sentinel = new IntNode(null, null, null);
    sentinel.next = sentinel;
    sentinel.prev = sentinel;
  }

  public LinkedListDeque(LinkedListDeque other) {
    size = 0;
    sentinel = new IntNode(null, null, null);
    sentinel.next = sentinel;
    sentinel.prev = sentinel;

    for (int i = 0; i < other.size; i++) {
      this.addLast((T) other.get(i));
    }
  }

  public void addFirst(T item) {
    IntNode newNode = new IntNode(sentinel, item, sentinel.next);
    IntNode oldNode = sentinel.next;
    sentinel.next = newNode;
    oldNode.prev = newNode;
    size += 1;
  }

  public void addLast(T item) {
    IntNode oldNode = sentinel.prev;
    IntNode newNode = new IntNode(oldNode, item, sentinel);
    sentinel.prev = newNode;
    oldNode.next = newNode;
    size += 1;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int size() {
    return this.size;
  }

  public void printDeque() {
    IntNode p = sentinel.next;
    for (int i = 0; i < size; i++) {
      System.out.print(p.item + " ");
      p = p.next;
    }
    System.out.println();
  }

  public T removeFirst() {
    T result = sentinel.next.item;
    IntNode oldNode = sentinel.next.next;
    sentinel.next = oldNode;
    oldNode.prev = sentinel;
    size -= 1;
    return result;
  }

  public T removeLast() {
    T result = sentinel.prev.item;
    IntNode oldNode = sentinel.prev.prev;
    sentinel.prev = oldNode;
    oldNode.next = sentinel;
    size -=1;
    return result;
  }

  public T get(int index) {
    IntNode p = sentinel.next;

    while(index != 0) {
      index--;
      p = p.next;
    }
    return p.item;
  }

  public T getRecursive(int index) {
    return getHelper(index, sentinel.next);
  }

  public T getHelper(int index, IntNode x) {
    if (index == 0) {
      return x.item;
    } else {
      return this.getHelper(index - 1, x.next);
    }
  }

  public T getFirst() {
    return sentinel.next.item;
  }

  public T getLast() {
    return sentinel.prev.item;
  }

  public static void main (String args[]) {
    LinkedListDeque<Integer> l1 = new LinkedListDeque<>();
    // l1.addFirst(10);
    // l1.addFirst(20);
    // l1.addFirst(30);
    l1.addLast(1);
    l1.addLast(2);
    l1.addLast(3);
    l1.addLast(4);
    // System.out.println(l1.removeLast());
    // System.out.println(l1.getFirst());
    // System.out.println(l1.getLast());
    System.out.println(l1.get(11));
    System.out.println(l1.getRecursive(11));
    l1.printDeque();
    LinkedListDeque<Integer> l2 = new LinkedListDeque<>(l1);
    l2.printDeque();
  }
}
