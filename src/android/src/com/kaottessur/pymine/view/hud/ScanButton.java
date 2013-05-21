package com.kaottessur.pymine.view.hud;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;

public class ScanButton extends HUDButton {

	public ScanButton(Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super(0, level, vertexBufferObjectManager);
	}

	@Override
	protected void performButtonAction() {
		drone.scan();
	}

}
