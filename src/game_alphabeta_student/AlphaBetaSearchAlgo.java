package game_alphabeta_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		int result = maxValue(node, Integer.MIN_VALUE , Integer.MAX_VALUE);
		System.out.println("the optimal value is: "+ result);
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		int result = Integer.MIN_VALUE;
		if(node.getChildren().isEmpty())return node.getValue();
		List<Node>children = node.getChildren();
		Collections.sort(children, Node.LabelComparator);
		for(Node child:children) {
			alpha = (result> alpha)?result:alpha;
			result = Math.max(result, minValue(child, alpha, beta));
		}
		return result;
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		// Enter your code here
		int result = Integer.MAX_VALUE;
		if(node.getChildren().isEmpty())return node.getValue();
		List<Node>children = node.getChildren();
		Collections.sort(children, Node.LabelComparator);
		for(Node child:children) {
			beta = (result< beta)?result:beta;
			result = Math.min(result, maxValue(child, alpha, beta));
		}
		return result;
	}
	public static void main(String[] args) {

			Node A = new Node("A");
			Node B = new Node("B");
			Node C = new Node("C");
			Node D = new Node("D", 0);
			Node E = new Node("E");
			Node F = new Node("F");
			Node G = new Node("G", -5);
			Node H = new Node("H", 3);
			Node I = new Node("I", 8);
			Node J = new Node("J");
			Node K = new Node("K");
			Node L = new Node("L", 2);
			Node M = new Node("M");
			Node N = new Node("N", 4);
			Node O = new Node("O");
			Node P = new Node("P", 9);
			Node Q = new Node("Q", -6);
			Node R = new Node("R", 0);
			Node S = new Node("S", 3);
			Node T = new Node("T", 5);
			Node U = new Node("U", -7);
			Node V = new Node("V", -9);
			Node W = new Node("W", -3);
			Node X = new Node("X", -5);

			A.addChild(B);
			A.addChild(C);
			A.addChild(D);
			A.addChild(E);
			B.addChild(F);
			B.addChild(G);
		
			C.addChild(H);
			C.addChild(I);
			C.addChild(J);
			
			E.addChild(K);
			E.addChild(L);
			E.addChild(M);
			
			F.addChild(N);
			F.addChild(O);
			
			J.addChild(P);
			J.addChild(Q);
			J.addChild(R);
			
			K.addChild(S);
			K.addChild(T);
			
			M.addChild(U);
			M.addChild(V);
			
			O.addChild(W);
			O.addChild(X);

			ISearchAlgo alphaBeta = new AlphaBetaSearchAlgo();
			System.out.println("AlphaBeta-Left To Right");
			alphaBeta.execute(A);
	}
}
