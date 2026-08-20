class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Count frequency
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Min heap based on frequency
        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int num : map.keySet()) {

            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Build answer
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}