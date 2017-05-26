/*
 In a simple expression tree (normal arithmetic operations and no parentheses), the precedence and associativity of the operators may be ignored.
 For example, let's say his program is given the expression "5+2-3-4*2". Each operator is
 supposed to be left associative, but the program could spit out the wrong tree:
 
 The expressions should be interpreted as follows:
1) The order of operations gives * and / highest precedence whereas + and - have lowest.
 	* and / have equal precedence. 
	+ and - have equal precedence.
	
2) Amongst operations of equal precedence, process the leftmost operation first.

Adhering to these rules, the input above would be processed to produce the Correct Tree.
 In such a tree, lower nodes are processed before higher nodes. 
 The value of a number node is the number itself. The value of an operation node is that operation applied to the values of its
  left and right subnodes (the value of the left subnode belongs on the left side of the operation). The value of the tree is 
  the value of the top node (called the root node). Unfortunately, your partner's front-end may have violated rules 1 and 2
   numerous times. Luckily the ordering of his tree is not messed up. 
   
   This means that an inorder traversal of the tree beginning with the root will produce the original expression.
    
    Your program will take a badTree describing his tree, and will return an which is the correct value of the expression he parsed.
     All operations are integer operations so division truncates results. For example 5/3=1, and -5/3 = -1.

Each element of badTree will be in one of two forms (quotes for clarity):
1) "op X Y" : op is one of *,/,+,-. X,Y are integers referencing other elements of badTree (0-indexed). 
	X refers to the node's left child and Y refers to the node's right child.
	
2) "N" : N is a non-negative integer with no extra leading zeros.

Examples
0)
{"+ 1 2","5","- 3 4","2","- 5 6","3","* 7 8","4","2"}
Returns: -4
The example in the problem statement.
1)
{"- 1 2","5","- 3 4","2","- 5 6","3","* 7 8","4","2"}
Returns: -8
The example in the problem statement with the + replaced by a -.
2)
{"* 1 2","5","- 3 4","2","- 5 6","3","* 7 8","4","2"}
Returns: -1
The example in the problem statement with the + replaced by a *.
3)
{"99"}
Returns: 99
*/