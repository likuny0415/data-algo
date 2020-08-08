public class ArrayDeque<T> {
   T[] items;
   int size;
   int nextFirst;
   int nextLast;

  public ArrayDeque() {
    items = (T []) new Object[8];
    nextFirst = 0;
    nextLast = 1;
    size = 0;
  }

  public ArrayDeque(ArrayDeque other) {
    items = (T []) new Object[other.items.length];
    nextFirst = other.nextFirst;
    nextLast = other.nextLast;
    size = other.size;

    System.arraycopy(other, 0, items, 0, size);
  }

  public void addFirst(T item) {
    // size > items.length ==> upSize
    // upSize the items.length * 2
    if (size == items.length) {
      upSize();
    }

    /**
     * 1. Make sure that the size < items.length
     * 2. update the nextFirst
     **/


    items[nextFirst] = item;
    size += 1;

    nextFirst = minusOne(nextFirst);
  }

  public void addLast(T item) {
    if (size == items.length) {
      upSize();
    }

    items[nextLast] = item;
    size += 1;
    nextLast = plusOne(nextLast);
  }

  public int minusOne(int i) {
    if (i == 0) {
      i = items.length - 1;
      return i;
    } else {
      i--;
      return i;
    }
  }

  public int plusOne(int i) {
    if (i == items.length - 1) {
      i = 0;
      return i;
    } else {
      i++;
      return i;
    }
  }

  public void printDeque() {
    for (int i = plusOne(nextFirst); i != nextLast; plusOne(i)) {
      System.out.print(items[i] + " ");
    }
    System.out.println();
  }

  public boolean isEfficient() {
    return size / items.length <= 0.25 && items.length >= 16;
  }


  public T removeFirst() {
    if (!isEfficient()) {
      downSize();
    }

    if (size == 0) {
      return null;
    }

    nextFirst = plusOne(nextFirst);
    T result = items[nextFirst];
    size--;
    return result;
  }

  public T removeLast() {
    if (!isEfficient()) {
      downSize();
    }

    if (size == 0) {
      return null;
    }

    nextLast = minusOne(nextLast);
    T result = items[nextLast];
    size--;
    return result;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public T get(int index) {
    if (size == 0) {
      return null;
    } else {
      index = (plusOne(nextFirst) + index) / items.length;
      return items[index];
    }
  }

  // upSize: original items.length
  // ==> increase the items.length to double time
  // ==> copy the old array to new array
  public void resize(int capacity) {
    T[] newArray = (T[]) new Object[capacity];
    System.arraycopy(items, 0, newArray, 0,size);
    items = newArray;
    nextFirst = capacity - 1;
    nextLast = size;
   }

   public void upSize() {
     resize(size * 2);
   }

   public void downSize() {
     resize(size / 2);
   }



  public static void main(String[] args) {
    ArrayDeque<Object> a = new ArrayDeque<>();
    a.addFirst(7);
    a.addFirst(1);
    a.addFirst(1);
    a.addFirst(1);
    a.addFirst(1);
    a.addFirst(1);
    a.addFirst(1);
    a.addFirst(7);
    a.addFirst(8);



    System.out.println(a.size());
    System.out.println(a.items[15]);
    System.out.println(a.size());
    System.out.println(a.removeFirst());
    a.printDeque();



  }
}
