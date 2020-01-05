import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import javafx.util.Pair;

/**
 * @author changleamazing
 * @date 2020/1/5 11:31
 * source: https://leetcode-cn.com/contest/weekly-contest-170/problems/get-watched-videos-by-your-friends/
 **/
public class Solution {

    // 存储 id 的 level
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends,
            int id, int level) {
        int[] visited = new int[watchedVideos.size()];
        Arrays.fill(visited, -1);
        // 存放当前 level 中的元素
        Queue<Integer> queue = new LinkedList<>();
        visited[id] = 1;
        queue.add(id);
        int depth = 0;
        while (!queue.isEmpty() && depth < level) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curFriendId = queue.poll();
                for (int j = 0; j < friends[curFriendId].length; j++) {
                    int friendId = friends[curFriendId][j];
                    if (visited[friendId] == -1) {
                        queue.add(friendId);
                        visited[friendId] = 1;
                    }
                }
            }
            depth++;
        }

        HashMap<String, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            List<String> videoList = watchedVideos.get(queue.poll());
            videoList.forEach(o -> map.put(o, map.getOrDefault(o, 0) + 1));
        }
        PriorityQueue<Pair<String, Integer>> priorityQueue = new PriorityQueue<>((t1, t2) -> {
            if (t1.getValue().equals(t2.getValue())) {
                return t1.getKey().compareTo(t2.getKey());
            } else {
                return t1.getValue() - t2.getValue();
            }
        });

        map.forEach((key, value) -> priorityQueue.offer(new Pair<>(key, value)));
        List<String> res = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.poll().getKey());
        }
        return res;
    }


    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list2.add("C");
        list3.add("B");
        list3.add("C");
        list4.add("D");
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        int[][] friends = new int[][]{{1, 2}, {0, 3}, {0, 3}, {1, 2}};
        new Solution().watchedVideosByFriends(lists, friends, 0, 1);
    }
}
