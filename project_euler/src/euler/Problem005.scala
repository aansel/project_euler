package euler

object Problem005 {

  def main(args: Array[String]): Unit = {
    println(findDivisible(20))
    
  }
  
  /**
   * Trouver le nombre divisible par tous les entiers de 1 à maxNumber
   */
  def findDivisible(maxNumber: Int): Int = {
    
    val downLimit = maxNumber / 2
    var divisible = 0
    var testNumber = 0
    while (divisible == 0) {    	
      testNumber += maxNumber
      (maxNumber to downLimit by -1).toStream
        .takeWhile(i => testNumber % i == 0)
        .foreach(i => if (i == downLimit) divisible = testNumber)
    }
    divisible
  }

}