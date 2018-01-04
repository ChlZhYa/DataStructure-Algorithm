import java.util.Objects;

/**
 * User: Changle
 * Date: 2017-11-12 14:27
 * Description: 算法第四版-2.4.1
 */

public class Ex_2_4_1 {

    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(args.length);
        for (int i = 0; i < args.length; i++) {
            if (!args[i].equals("*")) {
                priorityQueue.insert(args[i]);
                System.out.println("最大元素为" + priorityQueue.max() + " ");
            } else {
                System.out.print("删除" + priorityQueue.delMax() + " ");
            }
        }
    }
}
