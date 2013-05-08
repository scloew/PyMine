from DefenseAdder.standard_adder import StandardDefenseAdder

class GridSquareContent:
    """ Represents a Grid Square Content """
    adderClass = StandardDefenseAdder
    fragile = False
    powerRating = 0
    reverseReadings = False
    
    def isDeactivated(self):
        """ Return if the content is deactivated """
        return True
    
    def isMine(self):
        """ Return if the Grid Square Content is a mine """
        return False
        
    def performGameCycle(self, minefield, drone):
        """ Perform the Game Cycle """
        
    # Drone Action Responses
    def scan(self, drone):
        """ Do nothing """
        
    def defuse(self, drone):
        """ Do nothing """

    def defuseCarefully(self, drone):
        """ Do nothing """
    
    def hitByEMP(self, drone):
        """ Do Nothing """