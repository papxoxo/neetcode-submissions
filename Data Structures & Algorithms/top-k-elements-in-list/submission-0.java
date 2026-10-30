class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums){
            count.put(num, count.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> minheap = new PriorityQueue<>(
            (a,b) -> count.get(a) - count.get(b)
        );

        for(int num : count.keySet()){
            minheap.add(num);
            if(minheap.size() > k){
                minheap.poll();
            }
        }

        int[] res = new int[k];
        for(int i=k-1; i>=0; i--){
            res[i] = minheap.poll();
        }
        return res;
    }
}
