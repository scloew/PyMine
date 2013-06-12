package com.kaottessur.pymine.view.defense;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.view.GridPositionHelper;

public abstract class DefenseSprite extends Sprite {
	protected DefenseInterface defense;
	
	public DefenseSprite(Class<?> defenseClass, DefenseInterface defense, VertexBufferObjectManager vertexBufferObjectManager) {
		super(0, 0, DefenseTextureWrapper.getNormalTexture(defenseClass), vertexBufferObjectManager);
		this.defense = defense;
		setVisible(false);
		moveToCurrentGridSquareLocation();
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
				update(pSecondsElapsed);
				setProperTexture();
				setVisible(defense.isVisible());
			}
		});
	}
	
	private void setProperTexture() {
		if (defense.isDeactivated()) {
        	setTextureRegion(DefenseTextureWrapper.getDeactivatedTexture(getDefenseClass()));
        	setVisible(true);
		}
        else
        	setTextureRegion(DefenseTextureWrapper.getNormalTexture(getDefenseClass()));
	}
	
	protected abstract void update(float secondsElapsed);
	protected abstract Class<?> getDefenseClass();
	protected abstract String getDeactivatedFilename();
	protected abstract String getActiveFilename();
	
	protected void moveToCurrentGridSquareLocation() {
		setPosition(GridPositionHelper.GetXLocation(defense.getGridSquare()), GridPositionHelper.GetYLocation(defense.getGridSquare()));
	}
	
	public DefenseInterface getDefense() {
		return defense;
	}
}
