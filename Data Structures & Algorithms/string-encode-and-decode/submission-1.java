class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s: strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        System.out.println(str);
        List<String> res = new ArrayList<>();

        int state = 0;
        StringBuilder buffer = new StringBuilder();
        int length = -1;
        for (char c: str.toCharArray()) {
            if (state == 0 && c != '#') {
                buffer.append(c);
                continue;
            }

            if (state == 0 && c == '#') {
                String numberString = buffer.toString();
                length = Integer.parseInt(numberString);
                if (length == 0) {
                    res.add("");
                    buffer = new StringBuilder();
                    continue;
                }

                state = 1;
                buffer = new StringBuilder();
                continue;
            }

            if (state == 1 && length != 0) {
                buffer.append(c);
                length -= 1;
            }

            if (state == 1 && length == 0) {
                String word = buffer.toString();
                res.add(word);
                buffer = new StringBuilder();
                state = 0;
                continue;
            }
        }

        return res;
    }
}
