package com.kaottessur.pymine.view.defense;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.defense.FragileMine;
import com.kaottessur.pymine.defense.Mine;
import com.kaottessur.pymine.defense.ReverseMine;
import com.kaottessur.pymine.defense.Worm;
import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.Minefield;

public class DefenseViewFactory {
	
	public static DefenseSprite getDefenseView(DefenseInterface defense, Drone drone, Minefield minefield, VertexBufferObjectManager vertexBufferObjectManager) {
		if (defense.getClass() == Mine.class) {
			return new MineSprite((Mine) defense, vertexBufferObjectManager);
		} else if (defense.getClass() == ReverseMine.class) {
			return new ReverseMineSprite((Mine) defense, vertexBufferObjectManager);
		} else if (defense.getClass() == FragileMine.class) {
			return new FragileMineSprite((Mine) defense, vertexBufferObjectManager);
		} else if (defense.getClass() == Worm.class) {
			return new WormSprite((Worm) defense, drone, minefield, vertexBufferObjectManager);
		}
		return null;
	}
	
}
