from clue import Clue

class GridSquare:
    """ Represents a square in the Minefield Grid """
    
    def __init__(self, row, column):
        """ Initialize the Grid Square """
        self.row = row
        self.column = column
        self.scanned = False
        self.clue = Clue()
        
        self.groundDefense = None
        
    def setGroundDefense(self, defenseObject):
        """ Set the Ground Defense """
        self.groundDefense = defenseObject
        
    def scan(self, drone):
        """ Scan the Grid Square """
        self.scanned = True
        if self.hasGroundDefense():
            self.groundDefense.scan(drone)
        self.clue.populate(drone.minefield, self.row, self.column)
        
    def defuse(self, drone):
        """ Defuse the Grid Square """
        if self.hasGroundDefense():
            self.groundDefense.defuse(drone)
            
    def defuseCarefully(self, drone):
        """ Defuse the Grid Square """
        if self.hasGroundDefense():
            self.groundDefense.defuseCarefully(drone)
            
    def hitByEMP(self, drone):
        """ The Square is hit by an EMP """
        if self.hasGroundDefense():
            self.groundDefense.hitByEMP(drone)
            
    def getGroundDefense(self):
        if self.hasGroundDefense():
            return self.groundDefense
            
    def hasGroundDefense(self):
        """ Return if the Grid Square has Ground Defense """
        return self.groundDefense is not None
            
    def mined(self):
        """ Return if the Square has an ative Mine """
        if self.hasGroundDefense():
            return self.groundDefense.isMine()
        return False
        
    def reversed(self):
        """ Return if the Grid Square causes readings to be reversed """
        if self.hasGroundDefense():
            return self.groundDefense.reverseReadings
        return False
        
    def fragile(self):
        """ Returns if the square's defenses are fragile """
        if self.hasGroundDefense():
            return self.groundDefense.fragile
        return False
        
    def __repr__(self):
        """ Print the square as a string """
        if self.scanned:
            return str(self.clue)
        else:
            return "#"