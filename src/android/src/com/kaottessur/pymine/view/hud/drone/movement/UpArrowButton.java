package com.kaottessur.pymine.view.hud.drone.movement;

import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.hud.HUDButton;
import com.kaottessur.pymine.view.texture.TextureWrapper;

public class UpArrowButton extends HUDButton {

	public UpArrowButton(float x, float y, Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super(x, y, level, TextureWrapper.GetInstance().getLeftMovementButtonTexture(), vertexBufferObjectManager);
	}

	@Override
	protected void performButtonAction() {
		//drone.moveUp();
	}
	
	@Override
    public boolean onAreaTouched(TouchEvent touchEvent, float x, float y) {
		if (touchEvent.isActionDown() ) {
			drone.moveUp();
		}
		return super.onAreaTouched(touchEvent, x, y);
    }
}
