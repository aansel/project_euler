package euler

import euler.Utils._


object Problem012 {

  val primeStream = primes()
    
  def main(args: Array[String]): Unit = {
    
    val test = 127
//    println(getDivisorNumber(test))
//    println(getDivisorNumber2(test))
    println("***")
    
    val t1 = System.currentTimeMillis()
    println(triangleNumbers().dropWhile(getDivisorNumber2(_) < 500).first)
    val t2 = System.currentTimeMillis()
    println((t2 - t1) + " ms")
  }

  def firstTriangleNumer(minDivisors: Int): Long = {
    triangleNumbers()
    0L
  }
  
  /**
   * Retourne un stream de nombres triangulaires
   */
  def triangleNumbers(): Stream[Long] = {
    def getNextValue(index: Long, iValue: Long): Stream[Long] = {
      val nextValue = (iValue + index + 1)
      nextValue #:: getNextValue(index + 1, nextValue)
    }
	1 #:: getNextValue(1, 1)
  }
  
  
  def getDivisorNumber2(number: Long): Int = {
    var divisorNumber = 1
    val limit = Math.floor(Math.sqrt(number)).toLong
    var quotient = number
    
    primeStream.takeWhile(prime => quotient > 1 && (prime <= limit || quotient != number)).foreach(prime => {
      var exposant = 1
      while (quotient % prime == 0) {
        quotient = quotient / prime
        exposant += 1
      }
      divisorNumber *= exposant
    })
    divisorNumber
  }
  
  
  /**
   * Retourne le nombre de diviseurs d'un nombre
   */
  def getDivisorNumber(number: Long): Int = {
    val limit = Math.floor(Math.sqrt(number)).toLong
    var divisorNumber = 2
    (2L to limit).foreach(divisor => 
      if (number % divisor == 0) {
        if (number == divisor * divisor) {
          divisorNumber += 1  
        } else {
          divisorNumber += 2  
        }
    	
      }
    )
    divisorNumber
  }
  
}