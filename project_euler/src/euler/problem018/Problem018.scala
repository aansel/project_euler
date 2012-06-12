package euler.problem018
import scala.io.Source

object Problem018 {

  def main(args: Array[String]): Unit = {
  
    val t1 = System.currentTimeMillis()
    println(maxRoute("triangle67.txt"))
    //println(otherMaxRoute())
    val t2 = System.currentTimeMillis()
    println((t2 - t1) + " ms")
    
  }
  
  def maxRoute(fileName: String): Int = {
    
    val lines = Source.fromInputStream(getClass().getResourceAsStream(fileName)).getLines()
    val dimension = lines.length
    var routes = Array.ofDim[Int](dimension, dimension)
    var maxRoute = 0
      // Itérer sur les lignes
      lines.zipWithIndex.foreach{case (line, lineNumber) =>
        // Itérer sur les colonnes
    	line.split(" ").zipWithIndex.foreach{case (value, index) => 
    	  val maxPartialRoute = 
    	    if (lineNumber == 0) {
    	      value.toInt
    	    } else if (index == 0) {
    	      (value.toInt + routes(lineNumber - 1)(index))
    	    }
    	    else if (index == lineNumber) {
    	      (value.toInt + routes(lineNumber - 1)(index - 1))
    	    } 
    	    else {
    	      (value.toInt + routes(lineNumber - 1)(index - 1)) max (value.toInt + routes(lineNumber - 1)(index))
    	    }
    	  maxRoute = maxRoute max maxPartialRoute
    	  routes(lineNumber)(index) = maxPartialRoute
    	}
      }
    maxRoute
  }
  
  /**
   * Autre solution
   * Inverser le triangle simplifie beaucoup les choses...
   */
  def maxRoute2(): Int = {
    val data = Source.fromInputStream(getClass().getResourceAsStream("triangle67.txt")).mkString
    val dataTree = data.trim.split("\n").map(_.trim.split(" ").map(_.toInt)).reverse
    for (i <- 1 until dataTree.size; j <- 0 until dataTree(i).size) {
      dataTree(i)(j) += math.max(dataTree(i - 1)(j), dataTree(i-1)(j + 1))
    }
    dataTree.last.head
  }

}