import edu.princeton.cs.algs4.StdRandom;

/**
 * @User: Changle
 * @Date: 29/7/2017
 * @Description: 算法第四版-1.3.35
 */

public class RandomQueue<Item> {

 private Item[] item;
 private int N;

 public RandomQueue() {
  item = (Item[]) new Object[10];
 }

 public boolean isEmpty() {
  return N == 0;
 }

 @SuppressWarnings("unchecked")
 public void resize(int n) {
  Item[] temp = (Item[]) new Object[n];
  for (int i = 0; i < N; i++) {
   temp[i] = item[i];
  }
  item = temp;
 }

 public void enqueue(Item data) {
  if (N == item.length) {
   resize(2 * N);
  }
  item[N++] = data;
 }

 public Item dequeue() {
  if (isEmpty()) {
   return null;
  }
  int r = StdRandom.uniform(N);
  Item temp = item[r];
  item[r] = item[--N];
  item[N] = null;
  return temp;
 }

 public Item sample() {
  if (isEmpty()) {
   return null;
  }
  int r = StdRandom.uniform(N);
  Item ret = item[r];
  return ret;
 }

 public int size() {
  return N;
 }

 //分发牌,根据enqueue方法可以确定不会发出两张相同的牌
 public RandomQueue<Item> sendCard(){
  RandomQueue<Item> queue = new RandomQueue<>();
  for (int i = 0; i < 13;i++){
   queue.enqueue(this.dequeue());
  }
  return queue;
 }

 //展示每个人获得的牌
 public void display(){
  for (int i = 0; i < 13; i++) {
   System.out.print(this.dequeue() + " ");
  }
  System.out.println();
 }

 public static void main(String[] args) {
  RandomQueue<Card>  cardQueue = new RandomQueue<>();

  String[] fget = {"黑桃", "红桃", "梅花", "方块"};
  String[] nget = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};


  //将牌放入容器内
  for (int i = 0; i < fget.length ; i++) {
   for (int j = 0; j < nget.length ; j++) {
    cardQueue.enqueue(new Card(fget[i],nget[j]));
   }
  }

  //将牌分发到四个玩家手中并展示四个玩家的牌
  for (int i = 0;i < 4;i++){
   cardQueue.sendCard().display();
  }


 }

}

class Card {

 private String num;
 private String flowercolor;
 private String cardName;



 public Card(String flowercolor, String num) {

  cardName = flowercolor + num;

 }

 @Override
 public String toString() {
  return cardName;
 }



}
