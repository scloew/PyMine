package com.kaottessur.pymine.defense;

import com.kaottessur.pymine.defense.adder.DefenseAdderInterface;
import com.kaottessur.pymine.defense.adder.StandardDefenseAdder;

public abstract class Defense implements DefenseInterface {
	protected boolean deactivated = false;
	
	public Defense() {
		
	}
	
	public boolean isDeactivated() {
		return deactivated;
	}
	
	public DefenseAdderInterface getDefenseAdder() {
		return new StandardDefenseAdder();
	}
}