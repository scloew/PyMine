from clue_view import ClueView
from mine_view import MineView

from PySide.QtCore import Qt
from PySide.QtGui import QImage, QMatrix

class GridSquareView:
    """ Represents the Graphical view of the Grid Square """
    GRID_SQUARE_SIZE = 64

    def __init__(self, gridSquare):
        """ Initialize the grid square view """
        self.gridSquare = gridSquare
        self.scaled_grid_square = None
        self.loadGridSquareImage()
        
        self.clueView = ClueView(self.gridSquare.clue)
        if self.gridSquare.mined():
            self.mineView = MineView(self.gridSquare.contents[0])

    def loadGridSquareImage(self):
        """ Load the grid square image """
        self.unscaled_grid_square = QImage("GridSquare.png")
        self.scaled_grid_square = self.unscaled_grid_square.scaled(self.GRID_SQUARE_SIZE, self.GRID_SQUARE_SIZE)

    def draw(self, painter, window):
        """ Draw the image """
        painter.drawImage(self.gridSquare.column*self.GRID_SQUARE_SIZE, self.gridSquare.row*self.GRID_SQUARE_SIZE, self.scaled_grid_square)
        if self.gridSquare.mined():# and self.gridSquare.contents[0].defused:
            self.mineView.draw(painter, self.gridSquare)
        if self.gridSquare.scanned:
            self.clueView.draw(painter, self.gridSquare) 