package amdp.taxiamdpdomains.taxiamdp;

import amdp.amdpframework.AMDPMetaController;
import burlap.mdp.core.state.State;

public class TaxiMetaController extends AMDPMetaController {

	public TaxiMetaController() {
		
	}

	public boolean replan(int level) {
		for(int i = 0; i < stateStack.size(); i++) {
			//System.out.println("StateStack Level " + i + ": " + stateStack.get(i).toString().replaceAll("\n", " "));
			//System.out.println("Level " + i + " goalLocation: " + stateStack.get(i).get("passenger0:goalLocationAtt"));
		}
		boolean replanNow = false;
		//System.out.println("Level: " + level);
		if(level == 0) {
			State currentState = stateStack.get(level);
			State parentState = stateStack.get(level + 1);
			String currentGoal = currentState.get("passenger0:goalLocationAtt").toString();
			String parentGoal = parentState.get("passenger0:goalLocationAtt").toString();
			//System.out.println("currentGoal: " + currentGoal);
			//System.out.println("parentGoal: " + parentGoal);
			replanNow = !currentGoal.equals(parentGoal);
			//System.out.println("replanNow: " + replanNow);
		}
		
		if (replanNow) {
			System.out.println("Replanning");
		}
		
		return replanNow;
	}
	
}
