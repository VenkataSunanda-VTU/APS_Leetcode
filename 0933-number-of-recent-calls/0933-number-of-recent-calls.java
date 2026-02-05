import java.util.*;
class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    public int ping(int t) {
        queue.offer(t); // add new ping
        while (queue.peek() < t - 3000) { // remove old pings
            queue.poll();
        }
        return queue.size(); // number of pings in [t-3000, t]
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */