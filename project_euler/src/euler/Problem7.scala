package euler
import scala.collection.mutable.ListBuffer

object Problem7 {
  
  def main(args: Array[String]) {
     val t1 = System.currentTimeMillis()
	  println(findNthPrimerNumber(10001))
	  val t2 = System.currentTimeMillis()
	  println(t2 - t1)
  }
  
  /**
   * Crible d'Erathosthène...
   *  - on s'arrête à racine (n)
   *  - TODO : un nombre premier peut s'écrire sous la forme 6k +/- 1 : on peut donc tester seulement 1 nombre sur 3
   *  NB : appeler rest.length fait perdre tout l'avantage de s'arrêter à racine(n) (reste.length != 0 && )
   */
  def findNthPrimerNumber(n: Int): Int = {
    var primes = ListBuffer[Int](2)
    var testPrime = 1
    var i = 1
    while(i < n) {
      testPrime += 2
      val limit = scala.math.sqrt(testPrime)
      val reste = primes.toStream.dropWhile(prime => testPrime % prime != 0 && prime <= limit)
      if (testPrime % reste.first != 0) {
    	primes += testPrime
    	i += 1
      }
    }
    testPrime
  }
  
  
  /**
   * Crible d'Erathosthène...
   * TODO : s'arrêter à Racine(n)
   */
  def findNthPrimerNumber0(n: Int): Int = {
    var primes = ListBuffer[Int](2)
    var testPrime = 1
    var i = 1
    while(i < n) {
      testPrime += 2
      if (primes.toStream.takeWhile(prime => testPrime % prime != 0).length == primes.length) {
    	primes += testPrime
    	i += 1
      }
    }
    testPrime
  }

}