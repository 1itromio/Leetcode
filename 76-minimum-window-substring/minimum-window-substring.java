class Solution {
    public String minWindow(String s, String t) {
        
        int n = s.length();
        int m = t.length();

        int freq[] = new int[128];
        int counts = m;

        for(int i = 0; i < m; i++) {
            freq[t.charAt(i)]++;
        }

        int lp = 0;
        int rp = 0;

        int minWindowSize = Integer.MAX_VALUE;
        int startIndex = -1;

        while(rp < n) {
            if(freq[s.charAt(rp)] > 0) {
                counts--;
            }
            freq[s.charAt(rp)]--;
            rp++;

            while(counts == 0) {
                if(minWindowSize > rp - lp) {
                    minWindowSize = rp - lp;
                    startIndex = lp;
                }

                freq[s.charAt(lp)]++;

                if(freq[s.charAt(lp)] > 0) {
                    counts++;
                }
                lp++;
            }

        }
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minWindowSize);
    }
}