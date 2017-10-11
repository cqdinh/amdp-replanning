package amdp.amdpframework;

import java.util.List;
import burlap.mdp.core.state.State;

public class AMDPMetaController {
	protected List<State> stateStack;
	
	public AMDPMetaController() {
		
	}
	
	public void setStateStack(List<State> stateStack) {
		this.stateStack = stateStack;
	}
	
	public boolean replan(int level) {
		return false;
	}
}
