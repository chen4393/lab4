import java.util.Scanner;

public class Histogram {
  private int left, right;
  private int[] data = null;
  public Histogram(int m, int n) {
    if (m > n) {
      m = m + n;
      n = m - n;
      m = m - n;
    }
    left = m;
    right = n;
    data = new int[right - left + 1];
  }
  public boolean add(int i) {
    if (i < left || i > right)
      return false;
    data[i - left]++;
    return true;
  }
  public void addOutOfRange(int i) {
    boolean addFlag = add(i);
    if (!addFlag) {
      boolean leftOutOfRange = false;
      boolean rightOutOfRange = false;
      int diff = 0;
      if (i > right) {
        right = i;
        rightOutOfRange = true;
      } else if (i < left) {
        diff = left - i;
        left = i;
        leftOutOfRange = true;
      }
      int[] tempData = new int[right - left + 1];
      if (rightOutOfRange == true) {
        for (int j = 0; j < data.length; j++)
          tempData[j] = data[j];
      }
      else if (leftOutOfRange == true) {
        for (int j = 0; j < data.length; j++)
          tempData[j + diff] = data[j];
      }
      data = tempData;
      data[i - left]++;
    }
  }
  public String toString() {
    String s = "";
    for (int i = 0; i < data.length; i++) {
      String stars = " ";
      for (int j = 0; j < data[i]; j++)
        stars += "*";
      String line = (i + left) + stars + "\n";
      s += line;
    }
    return s;
  }
  public static void main(String[] args) {
    Scanner s1 = new Scanner(System.in);
    System.out.print("Range? ");
    int m = 0, n = 0;
    if (s1.hasNext())
      m = s1.nextInt();
    if (s1.hasNext())
      n = s1.nextInt();
    Histogram h = new Histogram(m, n);
    System.out.println("(using regular add)");
    System.out.print("Data? ");
    while (s1.hasNext()) {
      int temp = s1.nextInt();
      if(!h.add(temp))
        System.out.println(temp + " is not in the range");
    }
    System.out.println();
    System.out.println(h.toString());

    Scanner s2 = new Scanner(System.in);
    System.out.println("(using addOutOfRange)");
    System.out.print("Enter one data point: ");
    if (s2.hasNext()) {
      int temp = 0;
      temp = s2.nextInt();
      h.addOutOfRange(temp);
    }
    System.out.println();
    System.out.println(h.toString());

    System.out.println("(using regular add)");
    System.out.print("More Data? ");
    Scanner s3 = new Scanner(System.in);
    while (s3.hasNext()) {
      int temp = s3.nextInt();
      if(!h.add(temp))
        System.out.println(temp + " is not in the range");
    }
    System.out.println();
    System.out.println(h.toString());
  }
}
