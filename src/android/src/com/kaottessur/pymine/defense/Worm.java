package com.kaottessur.pymine.defense;

import com.kaottessur.pymine.Power;
import com.kaottessur.pymine.level.Drone;

public class Worm extends Defense {

	@Override
	public boolean isVisible() {
		return true;
	}

	public int getPowerRating() {
		return Power.EMP_POWER;
	}
	
	@Override
	public void scan(Drone drone) {
		// Do Nothing	
	}

	@Override
	public void defuse(Drone drone) {
		// Do Nothing
	}

	@Override
	public void defuseCarefully(Drone drone) {
		// Do Nothing
	}

	@Override
	public void hitByEMP(Drone drone) {
		deactivate();
	}
}