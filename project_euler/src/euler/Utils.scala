package euler

object Utils {
  
  def main(args: Array[String]): Unit = {
    primes().takeWhile(_ < Math.sqrt(76576500)).foreach(println)
  }
  
  /**
   * Au delà de 3, tous les nombres premiers peuvent d'écrire sous la form 6k +/- 1
   * possiblePrimeStream renvoie un stream infini de nombre potentiellement premiers d'après cette règle
   */
  def possiblePrimeStream(): Stream[Int] = {
    def possiblePrimeStream(k: Int): Stream[Int] = {
      (6 * k - 1) #:: (6 * k + 1) #:: possiblePrimeStream(k + 1)
    }
    2 #:: 3 #:: possiblePrimeStream(1)
  }
  
  /**
   * Renvoie un stream de nombres premiers
   */
  def primes(): Stream[Int] = {
    possiblePrimeStream().filter(isPrime(_))
  }
  
  /**
   * Est-ce qu'nu nombre est premier?
   */
  def isPrime(number: Long): Boolean = {
    val limit = Math.sqrt(number)
    val primeSream = possiblePrimeStream().dropWhile(divisor => divisor <= limit && number % divisor != 0)
    primeSream.first > limit
  }

}