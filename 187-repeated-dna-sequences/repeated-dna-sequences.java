class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(int i = 0; i < s.length() - 10 + 1; i++) {
            String currSequence = s.substring(i, i + 10);
            int count = map.getOrDefault(currSequence, 0) + 1;
            //System.out.println(currSequence + ": " + count);
            map.put(currSequence, count);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}