package com.kaottessur.pymine.view.level.selection;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.text.Text;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.level.selection.LevelSelection;
import com.kaottessur.pymine.view.Button;
import com.kaottessur.pymine.view.SceneManager;
import com.kaottessur.pymine.view.texture.TextureWrapper;
import com.kaottessur.pymine.view.defense.DefenseCountEntity;

public class LevelDetailsScene extends Entity {
	
	public LevelDetailsScene(Scene parent, final LevelSelection levelSelection, VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		setPosition(600, 0);
		
		final Level level = levelSelection.getSelectedLevel();
		addHeader(level, vertexBufferObjectManager);
		addDefenseCounts(level, vertexBufferObjectManager);
		addPlayButton(parent, level, vertexBufferObjectManager);
	}
	
	private void addHeader(Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		addText(0, level.getName(), vertexBufferObjectManager);
		String text = Integer.toString(level.getMinefield().getRowCount()) + "x" + Integer.toString(level.getMinefield().getColumnCount());
		addText(50, text, vertexBufferObjectManager);
	}
	
	private void addDefenseCounts(Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		int row = 0;
		for (Class<? extends DefenseInterface> defenseClass : level.getDefenseClasses()) {
			DefenseCountEntity defenseCount = new DefenseCountEntity(50, 100+64*row, level, defenseClass, vertexBufferObjectManager);
			attachChild(defenseCount);
			row++;
		}
	}
	
	private void addPlayButton(Scene parent, final Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		Button playButton = new Button(50, 400, 100, 50, vertexBufferObjectManager)
		{
	        public void performButtonAction()
	        {
	            SceneManager.GetInstance().runLevelScene(level);
	        };
	    };
		attachChild(playButton);
		parent.registerTouchArea(playButton);
	}
	
	private void addText(float y, String text, VertexBufferObjectManager vertexBufferObjectManager) {
		Text textEntity = new Text(50, y, TextureWrapper.GetInstance().GetCompletionFont(), text, vertexBufferObjectManager);
		attachChild(textEntity);
		centerText(textEntity, 100);
	}
	
	private void centerText(Text text, float centerX) {
		float width = text.getWidth();
		text.setPosition(centerX-width/2, text.getY());
	}
}