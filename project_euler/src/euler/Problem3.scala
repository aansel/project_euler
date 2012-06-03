package euler

object Problem3 {
  
  def main(args: Array[String]) {
    println(getLargestPrimeFactorLong(600851475143L))    
  }
  
  /**
   * Decomposer un nombre en facteurs premiers
   */
  def getLargestPrimeFactor(number: Int): Int = {
    var primeFactor = 1;
    var reste = number
    while(reste > 1) {
    	primeFactor = (primeFactor + 1 to number).toStream.takeWhile(i => reste % i != 0).last + 1
    	println("facteur premier " + primeFactor)
    	reste = reste / primeFactor    	
  	}    
    primeFactor
  }
  
  
  /**
   * Decomposer un nombre en facteurs premiers, modifié pour fonctionner avec des Long
   */
  def getLargestPrimeFactorLong(number: Long): Long = {
    var primeFactor = 2;
    var reste = number
    while(reste > 1) {
      while (reste % primeFactor != 0) {
        primeFactor += 1
      }
      println("facteur premier " + primeFactor)
      reste = reste / primeFactor    	
  	}    
    primeFactor
  }

}