package euler

object Problem020 {

  def main(args: Array[String]): Unit = {
    val t1 = System.currentTimeMillis()
    println(digitSum(factorielle(100)))
    val t2 = System.currentTimeMillis()
    println((t2 - t1) + " ms")
  }
  
  def factorielle(number: Long): BigInt = {
    (number to 2 by -1).foldLeft(BigInt(1))(_ * _)
  }
  
  def digitSum(number: BigInt): Int = {
    number.toString.foldLeft(0)((sum, digit) => sum + digit.toString().toInt)
  }

}