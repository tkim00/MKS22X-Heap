public class MyHeap {
  private static void swap(int[]data, int i, int j) {
    int x = data[i];
    data[i] = data[j];
    data[j] = x;
  }

  public static void pushDown(int[]data,int size,int index) {
    int c1 = 2*index+1;
    int c2 = 2*index+2;
    if (c1 > size  //there may be some edge cases that I have to cover
                  //this might happen when data[index] is passed towards bottom right
    || (data[index] > data[c1] && data[index] > data[c2])) {
      return;
    } else {
      if (c1 != size) {
        if (data[c1] > data[c2]) {
          swap(data, c1, index);
          pushDown(data, size, c1);
        } else {
          swap(data, c2, index);
          pushDown(data, size, c2);
        }
      } else {
        swap(data, c1, index);
        pushDown(data, size, c1);
      }
    }
  }

  private static void pushUp(int[]data,int index) {
    // int p = (index-1)/2;
    // if () {
    //
    // }
  }
}
