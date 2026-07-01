class Solution { 

    public List<String> strings = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        int open = n;
        int close = n;

        recurse('(', open, close, new StringBuilder(""));

        return strings;
    }

    public void recurse(char par, int open, int close, StringBuilder string) {
        int o = open;
        int c = close;
        
        string.append(par);

        if (par == '(') {
            o -= 1;
        }  else {
            c -= 1;
        }

        if(o == 0 && c == 0) {
            strings.add(string.toString());
            System.out.println("Added string: " + string.toString());
            return;
        }

        System.out.println("Open: " + o + " Closed: " + c);

        if(o > 0) {
            recurse('(', o, c, new StringBuilder(string));
        }

        if(o < c) {
            recurse(')', o, c, new StringBuilder(string));
        }
    }
}
