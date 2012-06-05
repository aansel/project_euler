package euler

import scala.math.pow

object Problem6 {

  def main(args: Array[String]): Unit = {
    
    val number = 100;
    println("%05d".format(7125))
    println((squareOfSum(number) - sumOfSquares(number)) * 2)
    
  }
  
  // Somme des carrés de 1 à maxNumber
  def sumOfSquares(maxNumber: Int): Double = {
    ((0 toDouble) /: (1 to maxNumber).toList){(sum, i) => sum + pow(i, 2)}
  }
  
  // Carré de la somme de 1 à maxNumber
  def squareOfSum(maxNumber: Int): Double = {
    pow(maxNumber * (maxNumber + 1) / 2, 2)
  }

}