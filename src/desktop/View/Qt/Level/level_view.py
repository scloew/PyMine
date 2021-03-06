from game_status_view import GameStatusView
from level_completion_view import LevelCompletionView
from minefield_view import MinefieldView

from PySide.QtCore import Qt
from PySide.QtGui import QFrame, QPainter

class LevelView(QFrame):
    """ Represents the View of the Level """

    def __init__(self, parent, level):
        """ Initialize the Level View """
        QFrame.__init__(self, parent)

        self.resize(640, 480)
        self.level = level
        self.minefield_view = MinefieldView(self.level.minefield, self.level.drone, self)
        
        self.levelCompletionView = LevelCompletionView(self.level, self.minefield_view.getWidth(), 480-self.minefield_view.getHeight(), self)
        self.levelCompletionView.move(0, self.minefield_view.getHeight())
        
        self.gameStatusBar = GameStatusView(level, 640-self.minefield_view.getWidth(), 480, parent=self)
        self.gameStatusBar.move(self.minefield_view.getWidth(), 0)

        self.setFocusPolicy(Qt.StrongFocus)
        

    def paintEvent(self, event):
        """ Paint the Level """
        self.minefield_view.updateView()
        self.gameStatusBar.updateView()
        self.levelCompletionView.updateView()
        
        if self.level.lost():
            self.minefield_view.revealAllMines()