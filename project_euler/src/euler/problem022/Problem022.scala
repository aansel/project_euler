package euler.problem022

import io.Source

/**
 * User: antoine
 * Date: 30/06/12
 * Time: 10:36
 */

object Problem022 extends App {
  
  println(Source.fromInputStream(getClass().getResourceAsStream("names.txt"))
      // Sort data
      .getLine(0).split(",").sortWith(_ < _)
      // Add index
      .view.zipWithIndex
      .foldLeft(0L){(sum, element) => 
        element match {
          case (word, index) => {
            sum + (index + 1) * wordValue(word)
          }
        }
  	  }
  )
 
  def letterValue(letter: Char): Int = {
    if (letter >= 'A' && letter <= 'Z') {
      letter.toInt - 'A'.toInt + 1
    } else {
      0
    }
  }
  
  def wordValue(word: String): Int = {
    word.toCharArray().foldLeft(0)((sum, letter) => sum + letterValue(letter))
  }
}
