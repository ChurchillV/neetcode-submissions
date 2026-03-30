class Solution {
   public boolean checkInclusion(String s1, String s2) {
		int size1 = s1.length();
		Map<Character, Integer> freqMap1 = new HashMap();
		
		for(int i = 0; i < size1; i++) {
			freqMap1.put(s1.charAt(i), freqMap1.getOrDefault(s1.charAt(i), 0) + 1);
		}
		
		int left = 0;
		int size2 = s2.length();
		Map<Character, Integer> freqMap2 = new HashMap();
		
		for(int right = 0; right < size2; right++) {
			freqMap2.put(s2.charAt(right), freqMap2.getOrDefault(s2.charAt(right), 0) + 1);
			
			int windowSize = right - left + 1;
			if(windowSize > size1) {
				freqMap2.put(s2.charAt(left), freqMap2.getOrDefault(s2.charAt(left), 1) - 1);
				
				if(freqMap2.get(s2.charAt(left)) == 0) {
					freqMap2.remove(s2.charAt(left));
				}			
				
				left++;
			}
			
			if(freqMap2.equals(freqMap1)) {
				return true;
			}
		}
		
		return false;
	}
}
