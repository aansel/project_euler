package euler.problem010

object TestScala {

  def main(args: Array[String]): Unit = {
    
    println(possiblePrimeStream().foldLeft(true)((w, y) => true || 3 == 3))
    
  }
  
  
   def possiblePrimeStream(): Stream[Int] = {
	  def possiblePrimeStream(k: Int): Stream[Int] = {
	      (6 * k - 1) #:: (6 * k + 1) #:: possiblePrimeStream(k + 1)
	  }
	  2 #:: 3 #:: possiblePrimeStream(1)
  }

}