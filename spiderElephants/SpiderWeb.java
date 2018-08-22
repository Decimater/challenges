public class SpiderWeb
{
  private final int widthInElephants;
  private final int maxKilos;
  private final int standardElephantWeight = 1000; // Kg

  public SpiderWeb(int maxKilos, int widthInElephants) {
    this.maxKilos = maxKilos;
    this.widthInElephants = widthInElephants;
  }
  
  /***
  *  Computes amount of elephants web can carry
  *  each level takes an elephant less
  *  each elephant is 1000kg heavier than the previous layer
  *  top row can be incomplete
  */
  public int getElephantToleranceNumber () {
    if (widthInElephants <= 0 || maxKilos <= standardElephantWeight) return 0;
  
    int elephantWeight = standardElephantWeight;
    int totalWeight = 0;
    int totalElephants = 0;
    
    for (int rowWidthInElephants = widthInElephants; rowWidthInElephants > 0; rowWidthInElephants--) {
      int elephantsInRow = 0;
      
      while(elephantsInRow < rowWidthInElephants) {    
          if(maxKilos < totalWeight + elephantWeight) return totalElephants;
          
          elephantsInRow++;
          totalElephants++;
          totalWeight += elephantWeight;     
      }
    
      elephantWeight += standardElephantWeight;
    }
  
    return totalElephants;
  }
}  