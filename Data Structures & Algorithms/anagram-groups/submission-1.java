class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> grp = new HashMap<>();

        for(String s : strs){
            int[] cnt = new int[26];
            for(char c : s.toCharArray()){
                cnt[c - 'a']++;
            }
            String key = Arrays.toString(cnt);
            grp.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(grp.values());
    }
}
