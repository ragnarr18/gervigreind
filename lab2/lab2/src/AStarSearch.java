import java.util.ArrayList;
import java.util.List;

public class AStarSearch implements SearchAlgorithm {
	List<Action> pList = new ArrayList<Action>();
	private Heuristics heuristics;
	public AStarSearch(Heuristics h) {
		this.heuristics = h;
		
	}

	@Override
	public void doSearch(Environment env) {
		List<Action> moves = env.legalMoves(env.getCurrentState());
		heuristics.init(env);
		State theState = env.getCurrentState();
		int evaluation = heuristics.eval(theState);
		// System.out.println("this is the eval:" + evaluation);
		// if (evaluation == 0) {
		// 	pList.add(Action.TURN_ON);
		// }
		
		// 	pList.add(Action.GO);
		
		// env.doAction(Action.TURN_ON);
		Action randomAction = moves.get(0);
    	env.doAction(randomAction);
		State the2State = env.getCurrentState();
		int evaluation2 = heuristics.eval(the2State);
		
		List<Action> moves1 = env.legalMoves(env.getCurrentState());
		Action randomAction2 = moves1.get(0);
    	env.doAction(randomAction);
		System.out.println("this is the eval 1:" + evaluation);
		System.out.println("this is the eval 2:" + evaluation2);

		
		
		
		// TODO implement the search here
	}

	private void recDoSearch(Environment env) {

	};

	// private void returnHome (){

	// };

	@Override
	public List<Action> getPlan() {
		// TODO Auto-generated method stub
		return pList;
	}

	@Override
	public int getNbNodeExpansions() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxFrontierSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPlanCost() {
		// TODO Auto-generated method stub
		return 0;
	}

}
