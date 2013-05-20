package com.kaottessur.pymine.defense;

import com.kaottessur.pymine.level.Drone;

public class Mine extends Defense {
	
	public boolean isMine() {
		return true;
	}
	
	public void scan(Drone drone) {
		tryToDetonate(drone);
	}
	
	private void tryToDetonate(Drone drone) {
		if (!deactivated)
			drone.destroy();
	}
}
