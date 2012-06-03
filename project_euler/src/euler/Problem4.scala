package euler

object Problem4 {

  def main(args: Array[String]) {
	  println(palindrom2(999));
  }
  
  /**
   * Fonction palindrom avec boucles for, mais sans break
   */
  def palindrom(maxFactor: Int): Int = {
    var maxPalindrom = 0;  
    for (i <- maxFactor to 1 by -1) {
      for (j <- i to 1 by -1) {
    	  val product = i * j;
    	  if (product > maxPalindrom && isPalindrom(product)) {
    	    maxPalindrom = product
    	  }
      }
    }
    maxPalindrom
  }
  
  /**
   * Fonction palindroms avec stream. Permet de réaliser un break (takeWhile)
   * http://stackoverflow.com/questions/2742719/how-do-i-break-out-of-a-loop-in-scala
   */
  def palindrom2(maxFactor: Int): Int = {
    var maxPalindrom = 0;
    (maxFactor to 1 by -1).foreach(
        i => (i to 1 by -1).toStream.takeWhile(j => i * j > maxPalindrom)
          .foreach{ j =>
            val product =  i * j;
            if (isPalindrom(product)) {
              maxPalindrom = product
            }
          }
      )
    maxPalindrom
  }
  
  def isPalindrom(number: Int): Boolean = {    
    val digits = number.toString().toList
    digits == digits.reverse
  }
}