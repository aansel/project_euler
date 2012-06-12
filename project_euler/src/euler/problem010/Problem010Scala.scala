package euler.problem010

object Problem010Scala {
  
  def main(args: Array[String]): Unit = {
    println("Scala version")
    val t1: Long = System.currentTimeMillis() 
    println(sumPrimes(2000000))
    val t2: Long = System.currentTimeMillis()
    println((t2 - t1) + " ms")
  }
  
  // Somme des nombres premiers de 1 à limit
  def sumPrimes(limit: Int): Long = {
    possiblePrimeStream()
      .takeWhile(_ <= limit)
      .filter(isPrime(_))  
      .foldLeft(0L)(_ + _)
  }
  
  // Au delà de 3, tous les nombres premiers peuvent d'écrire sous la form 6k +/- 1
  // possiblePrimeStream renvoie un stream infini de nombre potentiellement premiers d'après cette règle
  def possiblePrimeStream(): Stream[Int] = {
    def possiblePrimeStream(k: Int): Stream[Int] = {
      (6 * k - 1) #:: (6 * k + 1) #:: possiblePrimeStream(k + 1)
    }
    2 #:: 3 #:: possiblePrimeStream(1)
  }

  // n est premier s'il n'est divisible par aucun premier de 1 à racine(n)
  val possiblePrimes = possiblePrimeStream()
  def isPrime(n: Int): Boolean = {
    val limit = Math.sqrt(n)
    val primeSream = possiblePrimes.dropWhile(divisor => divisor <= limit && n % divisor != 0)
    primeSream.first > limit
  }

}