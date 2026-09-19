
class Solution {
    public List<String> cellsInRange(String s) {
        char cs = s.charAt(0);
        char ce = s.charAt(3);
        char rs = s.charAt(1);
        char re = s.charAt(4);

        List<String> list = new ArrayList<>();
        for (char c = cs; c <= ce; c++)
            for (char r = rs; r <= re; r++)
                list.add(new String(new char[] { c, r }));
        return list;

    }
}