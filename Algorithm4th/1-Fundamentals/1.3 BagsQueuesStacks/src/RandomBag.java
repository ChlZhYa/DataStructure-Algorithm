import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

/**
 * @User: Changle
 * @Date: 29/7/2017
 * @Description: 算法第四版-1.3.34
 */

public class RandomBag<Item> implements Iterable<Item> {

 private Item[] item;
 private int N;

 @SuppressWarnings("unchecked")
 public RandomBag(int cap) {
  if (cap <= 0) {
   throw new RuntimeException("背包不存在");
  }
  item = (Item[]) new Object[cap];
 }

 public boolean isEmpty() {
  return N == 0;
 }

 public boolean isFull() {
  return N == item.length;
 }

 @SuppressWarnings("unchecked")
 public void resize(int n) {
  Item[] temp = (Item[]) new Object[n];
  for (int i = 0; i < N; i++) {
   temp[i] = item[i];
  }
  item = temp;
 }

 public int size() {
  return N;
 }

 public void add(Item data) {
  if (isFull()) {
   resize(2 * N);
  }
  item[N++] = data;
 }

 public Iterator<Item> iterator() {
  return new RandomBagIterator();
 }

 private class RandomBagIterator implements Iterator<Item> {

  private int current = 0;

  //随机打乱数组(洗牌算法)
  public RandomBagIterator() {
   for (int i = 0; i < N; i++) {
    int r = i + StdRandom.uniform(N - i);
    Item temp = (Item) item[i];
    item[i] = item[r];
    item[r] = temp;
   }
  }

  @Override
  public boolean hasNext() {
   return current != N;
  }

  @Override
  public Item next() {
   return (Item) item[current++];
  }
 }


 public static void main(String[] args) {
  RandomBag<Integer> rb = new RandomBag<>(6);
  for (int i = 0; i < 10; i++) {
   rb.add(i);
  }
  for (Integer t : rb)
   StdOut.print(t + " ");
 }
}
