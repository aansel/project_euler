package euler

object Problem1 {
  
  /**
   * 3 + 5 + 6 + 9 + 10 + 12
   * = 3 + 6 + 9 + 12 + 15 + 18
   * + 5 + 10 + 15 + 20
   * - 15 - 30 - 45... 
   */
  def main(args: Array[String]) =  {
    println(sum(3, 999) + sum(5, 999) - sum(15, 999))
  }
  
  def sum(raison: Int, limit: Int) = {
    val lastValue = limit - limit % raison
    (lastValue + raison) * lastValue / (2 * raison) 
  }

}