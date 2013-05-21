package com.kaottessur.pymine.view.level;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;

public class LevelScene extends Scene {
	private Level level;
	private MinefieldScene minefieldScene;
	
	private CompletionText wonText;
	private CompletionText lostText;
	
	
	public LevelScene(Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		
		this.level = level;
		minefieldScene = new MinefieldScene(this, level.getMinefield(), level.getDrone(), vertexBufferObjectManager);
		attachChild(minefieldScene);
		
		wonText = new CompletionText("You Won!", vertexBufferObjectManager);
		attachChild(wonText);
		lostText = new CompletionText("Game Over", vertexBufferObjectManager);
		attachChild(lostText);
		registerUpdate();
	}
		
	private void registerUpdate() {	
		registerUpdateHandler(new IUpdateHandler() {
			@Override
			public void reset() {
				// Do Nothing
			}
			
			@Override
			public void onUpdate(float pSecondsElapsed) {
				if (level.won())
					wonText.setVisible(true);
				else if (level.lost())
					lostText.setVisible(true);
			}
		});
	}
}