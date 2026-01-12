class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> st = new Stack<>();
        int len = formula.length();
        st.push(new HashMap<>());

        for (int i = 0; i < len;) {

            if (formula.charAt(i) == '(') {
                st.push(new HashMap<>());
                i++;
            }

            else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = st.pop();
                i++;
                int start = i;

                while (i < len && Character.isDigit(formula.charAt(i)))
                    i++;

                String num = formula.substring(start, i);
                int multiplier = start < i ? Integer.parseInt(num) : 1; // extracted number or else 1 if not given

                for (String element : top.keySet()) {
                    int x = top.get(element) * multiplier;
                    st.peek().put(element, st.peek().getOrDefault(element, 0) + x);
                }
            }

            else {
                int start = i;
                i++;

                while (i < len && Character.isLowerCase(formula.charAt(i)))
                    i++;

                String element = formula.substring(start, i); // atom
                start = i;

                while (i < len && Character.isDigit(formula.charAt(i)))
                    i++;

                String num = formula.substring(start, i); // extracted number or else 1 if not given
                int count = start < i ? Integer.parseInt(num) : 1;

                st.peek().put(element, st.peek().getOrDefault(element, 0) + count);
            }
        }

        Map<String, Integer> result = st.pop();
        List<String> list = new ArrayList<>(result.keySet());
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (String element : list) {
            sb.append(element);
            int val = result.get(element);

            if (val > 1)
                sb.append(val);
        }

        return sb.toString();
    }
}