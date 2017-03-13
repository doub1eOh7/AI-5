/*
01 function alphabeta(node, depth, alpha, beta, maximizingPlayer)
02      if depth = 0 or node is a terminal node
03          return the heuristic value of node
04      if maximizingPlayer
05          v := -INF
06          for each child of node
07              v := max(v, alphabeta(child, depth – 1, alpha, beta, FALSE))
08              alpha := max(alpha, v)
09              if beta <= alpha
10                  break (* beta cut-off *)
11          return v
12      else
13          v := INF
14          for each child of node
15              v := min(v, alphabeta(child, depth – 1, alpha, beta, TRUE))
16              beta := min(beta, v)
17              if beta <= alpha
18                  break (* alpha cut-off *)
19          return v
(* Initial call *)
alphabeta(origin, depth, -INF, +INF, TRUE)
 */

import java.util.Iterator;
import java.util.Random;

public class ABPruning {
	
	ChessState bestMove = new ChessState();

	public int alphabeta(ChessState node, int depth, int a, int b, boolean maxPlayer) throws Exception
	{
		ChessState.ChessMove m;
		Random rand = new Random();
		int v;
		if (depth == 0 || node.isOver())
		{
			//node.printBoard(System.out);
			//System.out.println(node.heuristic(rand));
			//System.out.println("UP");
			return node.heuristic(rand);
		}
		
		if (maxPlayer) //Maximizing PLayer
		{
			ChessState.ChessMoveIterator it = node.iterator(maxPlayer);
			v = Integer.MIN_VALUE;
			while(it.hasNext())
			{
				ChessState s = new ChessState(node);
				m = it.next();
				s.move(m.xSource, m.ySource, m.xDest, m.yDest);
				//s.printBoard(System.out);
				//System.out.println(m.xSource + " " + m.ySource + " " + m.xDest + " " + m.yDest);
				//System.out.println("Down");
				v = Math.max(v, alphabeta(s, depth - 1, a, b, false));
				//System.out.println(v);
				a = Math.max(a, v);
				if (b <= a)
				{
					//System.out.println("Prune");
					break; //Prune
				}
			}
			return v;
		}
		else //Minimizing Player
		{
			ChessState.ChessMoveIterator it = node.iterator(maxPlayer);
			v = Integer.MAX_VALUE;
			while(it.hasNext())
			{
				ChessState s = new ChessState(node);
				m = it.next();
				s.move(m.xSource, m.ySource, m.xDest, m.yDest);
				//s.printBoard(System.out);
				//System.out.println(m.xSource + " " + m.ySource + " " + m.xDest + " " + m.yDest);
				//System.out.println("Down");
				v = Math.min(v, alphabeta(s, depth - 1, a, b, true));
				//System.out.println(v);
				b = Math.min(b, v);
				if (b <= a)
				{
					//System.out.println("Prune");
					break; //Prune
				}
			}
			return v;
		}
	}
	
}
