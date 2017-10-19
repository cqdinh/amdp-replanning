package amdp.amdpframework;

import java.util.List;
import java.util.Stack;

import burlap.mdp.core.action.Action;
import burlap.mdp.core.state.State;

public class AMDPMetaController {
	protected List<State> stateStack;
	protected Stack<Action> trajectory;
	
	public AMDPMetaController() {
		trajectory = new Stack<Action>();
	}
	
	public void setStateStack(List<State> stateStack) {
		this.stateStack = stateStack;
	}
	
	public boolean replan(int level) {
		if(level == stateStack.size() - 1) return false;
		
		State currentState = stateStack.get(level);
		State parentState = stateStack.get(level + 1);
		for(Object o: currentState.variableKeys()){	
			String current = currentState.get(o).toString();
			try {
				String parent = parentState.get(o).toString();
				if (!current.equals(parent)) {
					System.out.println("Replanning");
					return true;
				}
			}
			catch (RuntimeException ex) {
				
			}
		}
		return false;
	}
	
	public void addTrajectory(Action a) {
		trajectory.push(a);
	}
	
	public Action removeTrajectory() {
		return trajectory.pop();
	}
	
	public String trajectoryString() {
		String result = trajectory.get(0).actionName();
		for (int i = 1; i < trajectory.size(); i++) {
			result = result + " -> " + trajectory.get(i).actionName();
		}
		return result;
	}
}
