class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Comparator<int[]> cmp = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        };

        PriorityQueue<int[]> minPQueue = new PriorityQueue<>(cmp);

        for (int num : map.keySet()) {
            minPQueue.add(new int[] {num, map.get(num)});
            if (minPQueue.size() > k) {
                minPQueue.poll();
            }
        }

        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = minPQueue.poll()[0];
        }

        return result;
    }
}
