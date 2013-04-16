from nytram.core.game_engine import TheGameEngine

class Drone:
    """ Represents the Player's Drone """
    
    def __init__(self, minefield):
        """ Intialize the Player's Drone """
        self.row = 0
        self.column = 0
        self.power = 100
        
        self.minefield = minefield
        self.destroyed = False
        
    def scan(self):
        """ Scan the current cell """
        self.power -= 2
        self.minefield.scan(self.row, self.column, self)
        
    def defuse(self):
        """ Defuse the current cell """
        self.power -= 5
        self.minefield.defuse(self.row, self.column, self)
        
    def destroy(self):
        """ Destroy the drone """
        self.destroyed = True
        
    def up(self):
        """  """
        if self.row > 0:
            self.row -= 1
            TheGameEngine.updateUI()
        
    def down(self):
        """ """
        if self.row < self.minefield.rowCount()-1:
            self.row += 1
            TheGameEngine.updateUI()
    
    def left(self):
        """ """
        if self.column > 0:
            self.column -= 1
            TheGameEngine.updateUI()
    
    def right(self):
        """ """
        if self.column < self.minefield.columnCount()-1:
            self.column += 1
            TheGameEngine.updateUI()