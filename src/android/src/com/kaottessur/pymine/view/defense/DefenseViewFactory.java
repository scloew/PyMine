package com.kaottessur.pymine.view.defense;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.defense.Mine;
import com.kaottessur.pymine.defense.ReverseMine;

public class DefenseViewFactory {
	
	public static Sprite getDefenseView(DefenseInterface defense, VertexBufferObjectManager vertexBufferObjectManager) {
		if (defense.getClass() == Mine.class) {
			return new MineSprite((Mine) defense, vertexBufferObjectManager);
		} else if (defense.getClass() == ReverseMine.class) {
			return new ReverseMineSprite((Mine) defense, vertexBufferObjectManager);
		}
		return null;
	}
	
}
