public class MyHeap {
  private static void swap(int[]data, int i, int j) {
    int x = data[i];
    data[i] = data[j];
    data[j] = x;
  }

  private static void pushDown(int[]data,int size,int index) {
    int c1 = 2*index+1;
    int c2 = 2*index+2;
    if (c1 != size) {
      if (c1 > size
      || (data[index] >= data[c1] && data[index] >= data[c2])) {
        return;
      }
      if (data[c1] > data[c2]) {
        swap(data, c1, index);
        pushDown(data, size, c1);
      } else {
        swap(data, c2, index);
        pushDown(data, size, c2);
      }
    } else {
      if (data[index] >= data[c1]) {
        return;
      }
      swap(data, c1, index);
      pushDown(data, size, c1);
    }
  }

  private static void pushUp(int[]data,int index) {
    int p = (index-1)/2;
    if (p > index || index == 0) {
      return;
    } else {
      swap(data, p, index);
      pushUp(data, p);
    }
  }

  public static void heapify(int[] data, int k) { //k is the index of the last element
    for (int i = (k-1)/2; i >= 0; i--) {
      pushDown(data, k, i);
    }
  }

  public static void heapsort(int[] data) {
    for (int k = data.length-1; k > 0; k--) {
      heapify(data, k);
      swap(data, 0, k);
    }
  }
}
