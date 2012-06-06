package euler
import scala.collection.mutable.ListBuffer

object Problem10 {

  def main(args: Array[String]): Unit = {
    val t1: Long = System.currentTimeMillis() 
    println(sumPrime(20))
    val t2: Long = System.currentTimeMillis()
    println(t2 - t1)
  }
  
  // Somme des nombres premiers de 1 à limit
  def sumPrime(limit: Int): Int = {
    
    var primes = ListBuffer[Int]()
    potentialPrimeStream()
    	.takeWhile(_ <= limit)
    	.foreach(x => if(isPrime(x, primes)){
    	  primes += x
    	})
    primes.foldLeft(0)(_ + _)
  }
  
  // Au delà de 3, tous les nombres premiers peuvent d'écrire sous la form 6k +/- 1
  // potentialPrimeStream renvoie un stream infini de nombre potentiellement premiers d'après cette règle
  def potentialPrimeStream(): Stream[Int] = {
	  def potentialPrimeStream(k: Int): Stream[Int] = {
	    if(k == 0) {
	      Stream.cons(2, Stream.cons(3, potentialPrimeStream(1)))
	    } else {
	      Stream.cons(6 * k - 1, Stream.cons(6 * k + 1, potentialPrimeStream(k + 1)))
	    }
	  }
	  potentialPrimeStream(0)
  }

  // On connait la liste des nombres premiers de 1 à n-1
  // n est premier s'il n'est divisible par aucun premier de 1 à racine(n)
  def isPrime(n: Int, primes: ListBuffer[Int]): Boolean = {
    println(n)
    if (primes.isEmpty) {
      true
    }
    else {
    	val limit = Math.sqrt(n)
	    val primesRestants = primes.dropWhile(prime => prime <= limit && n % prime != 0)
	    n % primesRestants.first != 0
    }
  }
}