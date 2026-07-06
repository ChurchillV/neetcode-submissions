class Solution {
    public List<String> result = new ArrayList();

    public Map<Character, ArrayList<Character>> digitMap = Map.of(
        '2', new ArrayList<>(List.of('a', 'b', 'c')),
        '3', new ArrayList<>(List.of('d', 'e', 'f')),
        '4', new ArrayList<>(List.of('g', 'h', 'i')),
        '5', new ArrayList<>(List.of('j', 'k', 'l')),
        '6', new ArrayList<>(List.of('m', 'n', 'o')),
        '7', new ArrayList<>(List.of('p', 'q', 'r', 's')),
        '8', new ArrayList<>(List.of('t', 'u', 'v')),
        '9', new ArrayList<>(List.of('w', 'x', 'y', 'z'))
    );

    public List<String> letterCombinations(String digits) {
        int SIZE = digits.length(); 
        int p1 = SIZE - 2;
        int p2 = SIZE - 1;

        if(SIZE == 1) {
            return digitMap.get(digits.charAt(p2)).stream()
                                    .map(String::valueOf)
                                    .collect(Collectors.toList());
        }

        while(p1 >= 0) {
            ArrayList<Character> arr1 = digitMap.get(digits.charAt(p1));
            ArrayList<Character> arr2 = (result.size() == 0) ? digitMap.get(digits.charAt(p2)) : new ArrayList(result);

            result = combine(arr1, arr2);
            p1--;
            p2--;
        }

        return result;
    }

    public List<String> combine(List<Character> a1, List<Character> a2) {
        int SIZE_1 = a1.size();
        int SIZE_2 = a2.size();
        List<String> res = new ArrayList();

        for(int i = 0; i < SIZE_1; i++) {
            for(int j = 0; j < SIZE_2; j++) {
                StringBuilder str = new StringBuilder();
                str.append(a1.get(i));
                str.append(a2.get(j));

                res.add(str.toString());
            }
        }

        return res;
    }
}
