package com.kaottessur.pymine.defense.adder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kaottessur.pymine.defense.AntiDroneMine;
import com.kaottessur.pymine.defense.AntiDroneTurret;
import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.level.Minefield;

public class AntiDroneMineAdder implements DefenseAdderInterface {
	private List<GridSquare> adjacentSquares;

	public AntiDroneMineAdder() {
		adjacentSquares = new ArrayList<GridSquare>();
	}

	@Override
	public void addDefense(DefenseInterface defense, Minefield minefield) {
		while (true) {
			GridSquare gridSquare = getGridSquare(minefield);
			if (!gridSquare.hasDefense()) {
				addDefenseToGridSquare(defense, gridSquare);
				addTurrets((AntiDroneMine) defense, minefield);
				break;
			}
		}
	}
	
	private GridSquare getGridSquare(Minefield minefield) {
		GridSquare centerSquare = null;
		while (true) {
			Random random = StandardDefenseAdder.random;
			int row =  random.nextInt(minefield.getRowCount());
			int column =  random.nextInt(minefield.getColumnCount()-2)+2;
			
			centerSquare = minefield.getGridSquareAt(row, column);
			
			List<GridSquare> adjacentSquares = minefield.getAdjacentGridSquares(centerSquare, false);
			boolean isGoodCenter = true;
			for (GridSquare adjacentSquare : adjacentSquares) {
				isGoodCenter = !adjacentSquare.hasDefense();
				if (!isGoodCenter)
					break;
			}
			
			if (isGoodCenter) {
				this.adjacentSquares = adjacentSquares;  
				break;
			}
		}
		return centerSquare;
	}
	
	private void addTurrets(AntiDroneMine antiDroneMine, Minefield minefield) {
		for (GridSquare gridSquare : adjacentSquares) {
			AntiDroneTurret turret = new AntiDroneTurret();
			addDefenseToGridSquare(turret, gridSquare);
			antiDroneMine.addTurret(turret);
		}
	}
	
	private void addDefenseToGridSquare(DefenseInterface defense, GridSquare gridSquare) {
		gridSquare.setDefense(defense);
		defense.setGridSquare(gridSquare);
	}
}
