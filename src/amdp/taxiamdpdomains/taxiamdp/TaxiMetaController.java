package amdp.taxiamdpdomains.taxiamdp;

import amdp.amdpframework.AMDPMetaController;
import burlap.mdp.core.state.State;

public class TaxiMetaController extends AMDPMetaController {
	
	public TaxiMetaController() {
		super();
	}

	public boolean replan(int level) {
		//for(int i = 0; i < stateStack.size(); i++) {
			//System.out.println("StateStack Level " + i + ": " + stateStack.get(i).toString().replaceAll("\n", " "));
			//System.out.println("Level " + i + " goalLocation: " + stateStack.get(i).get("passenger0:goalLocationAtt"));
		//}
		//System.out.println("Level: " + level);
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
			
			
			//System.out.println("currentGoal: " + currentGoal);
			//System.out.println("parentGoal: " + parentGoal);
			//replanNow = !currentGoal.equals(parentGoal);
			//System.out.println("replanNow: " + replanNow);
	}
	
}
