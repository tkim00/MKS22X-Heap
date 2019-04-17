public class MyHeap {
  private static void swap(int[]data, int i, int j) {
    int x = data[i];
    data[i] = data[j];
    data[j] = x;
  }

  private static void pushDown(int[]data,int size,int index) {
    int c1 = 2*index+1;
    int c2 = 2*index+2;
    if (c2 > size) {
      return;
    } else {
      if (data[c1] > data[c2]) {
        swap(data, c1, index);
        pushDown(data, size, c1);
      } else {
        swap(data, c2, index);
        pushDown(data, size, c2);
      }
    }
  }

}
