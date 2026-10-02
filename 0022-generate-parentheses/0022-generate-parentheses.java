class Solution {
    List<String> ans = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        generate(0, 0, new StringBuilder(), n);
        return ans;
    }

    public void generate(int opn, int cls, StringBuilder s, int n) {
        if (opn == n && cls == n) {
            ans.add(s.toString());
            return;
        }
        if (opn < n) {
            s.append('(');
            generate(opn + 1, cls, s, n);
            s.deleteCharAt(s.length() - 1);
        }
        if (cls < opn) {
            s.append(')');
            generate(opn, cls + 1, s, n);
            s.deleteCharAt(s.length() - 1);
        }
    }
}

// See tree diagram (given below) with parameters (opn, cls, s) for better understanding
//							    	(0, 0, '')
//								 	    |	
//									(1, 0, '(')  
//								   /           \
//							(2, 0, '((')      (1, 1, '()')
//							   /                   \
//						(2, 1, '(()')           (2, 1, '()(')
//						   /                          \
//					(2, 2, '(())')                (2, 2, '()()')
//						  |	                            |
//					ans.append('(())')            ans.append('()()') 