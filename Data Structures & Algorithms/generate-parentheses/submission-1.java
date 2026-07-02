class Solution {
    public List<String> strings = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        recurse('(', n, n, new StringBuilder(""));
        return strings;
    }

    public void recurse(char par, int open, int close, StringBuilder str) {
        int o = open;
        int c = close;

        str.append(par);

        if (par == '(') {
            o--;
        } else {
            c--;
        }

        if(o == 0 && c == 0) {
            strings.add(str.toString());
            return;
        }

        if(o > 0) {
            recurse('(', o, c, new StringBuilder(str));
        }

        if(o < c) {
            recurse(')', o, c, new StringBuilder(str));
        }
    }
}
