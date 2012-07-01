package euler


object Problem021 {

  def main(args: Array[String]): Unit = {
    
    val sum = (1 to 10000).foldLeft(0){(sum, number) => 
    	val sumProperDivisors = Utils.properDivisors(number).foldLeft(0)(_ + _)
    	if (sumProperDivisors > number) {
    	  val reverseSumProperDivisors = Utils.properDivisors(sumProperDivisors).foldLeft(0)(_ + _)
    	  if (reverseSumProperDivisors == number) {
    	    println(number + sumProperDivisors)
    	    sum + number + sumProperDivisors
    	  } else {
    	    sum
    	  }
    	} else {
    	  sum
    	}
    	
    }
    println(sum)
    
  }
  
  


}