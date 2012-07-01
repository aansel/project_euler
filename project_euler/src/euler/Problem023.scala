package euler
import scala.collection.mutable.HashMap

object Problem023 {
  
  val limit = 30000
  
  def main(args: Array[String]) {
 
    val t1 = System.currentTimeMillis()
  
    val abundantNumbersStream = abundantNumbers()
    var result = 0L
  
    (1 to limit).foreach{ number =>    
      // To check is a number can be written as the sum of abundant number, I substract a abundant number
      // from number and I check if the result is an abundant number
      val remainingStream = abundantNumbersStream.dropWhile{ abundantNumber =>
        number - abundantNumber > 0 && !isAbundant(number - abundantNumber)
      }

      // Check if  we have found a number that cannot be written as the sum of two abundant numbers 
      if (remainingStream.isEmpty || remainingStream.head >= number) {
        result += number
      }
    
    }

    println("res = " + result)
    val t2 = System.currentTimeMillis()
    println((t2 - t1) + " ms")

  }
  /**
   * Get stream of abundant numbers
   */
  def abundantNumbers(): Stream[Int] = {
    def abundantNumbers(start: Int): Stream[Int] = {
      start match {
        // There is no abundant number after limit        
        case n if (n <= limit) => {
          var number = start
            while(!isAbundant(number)) {
              number += 1
            }
          number #:: abundantNumbers(number + 1)
        }
        case _ => Stream.empty
      }
      
    }
    abundantNumbers(1)
  }
  
  /**
   * Is a number abundant?
   */
  val abundantNumberMap = new HashMap[Integer, Boolean]
  def isAbundant(number: Int): Boolean = {
    if(!abundantNumberMap.contains(number)) {
      abundantNumberMap(number) = Utils.properDivisors(number).foldLeft(0)(_ + _) > number
    }
    abundantNumberMap(number)
  }
  
}