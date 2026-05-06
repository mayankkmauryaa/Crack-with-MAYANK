class Solution {
    List<String> ans = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        generate(0, 0, "", n);
        return ans;
    }

    public void generate(int opn, int cls, String s, int n) {
        if (opn == n && cls == n) {
            ans.add(s);
            return;
        }
        if (opn < n)
            generate(opn + 1, cls, s + "(", n);
        if (cls < opn)
            generate(opn, cls + 1, s + ")", n);
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