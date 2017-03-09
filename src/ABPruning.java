/*
 * function minimax(node, depth, maximizingPlayer)
02     if depth = 0 or node is a terminal node
03         return the heuristic value of node

04     if maximizingPlayer
05         bestValue := −∞
06         for each child of node
07             v := minimax(child, depth − 1, FALSE)
08             bestValue := max(bestValue, v)
09         return bestValue

10     else    (* minimizing player *)
11         bestValue := +∞
12         for each child of node
13             v := minimax(child, depth − 1, TRUE)
14             bestValue := min(bestValue, v)
15         return bestValue
 */

import java.util.Iterator;

public class ABPruning {
	
	ChessState bestMove = new ChessState();

	public int minimax(ChessState node, int depth, boolean maxPlayer)
	{
		int bestValue;
		ChessState bestChoice = new ChessState();
		ChessState.ChessMoveIterator it = node.iterator(true);
		ChessState.ChessMove m;
		if (depth == 0 || node.)
		{
			return node.whoWon();
		}
		
		if (maxPlayer) //Maximizing PLayer
		{
			bestValue = Integer.MIN_VALUE;
			for(ChessState child : node.getChildren(false))
			{
				//System.out.println(node.toString());
				//System.out.println(child.toString());
				int value = minimax(child, depth - 1, false);
				bestValue = Math.max(bestValue, value);
			}
			return bestValue;
		}
		else //Minimizing Player
		{
			bestValue = Integer.MAX_VALUE;
			while(node.iterator(true).hasNext())
			{
				//System.out.println("Minimize:\n" + child.toString());
				int value = ABPruning(node.iterator(true).next(), depth - 1, true);
				bestValue = Math.min(bestValue, value);
			}
			return bestValue;
		}
	}
	
}
