package euler.problem011
import scala.io.Source

object Problem011 {

  def main(args: Array[String]): Unit = {
    val t1 = System.currentTimeMillis()
    println(getMaxProduct(4))
    val t2 = System.currentTimeMillis()
    println((t2 - t1) + " ms")
  }
  
  // Récupérer les données du fichier
  def getData(): Array[Array[Int]] = {
    val data = Array.ofDim[Int](20, 20)
    Source.fromInputStream(getClass()
        .getResourceAsStream("problem11.txt"))
        .getLines()
        .zipWithIndex
        .foreach{case (line, lineIndex) =>
          line.split(" ")
        	.zipWithIndex
        	.foreach{case (value, columnIndex) =>
        	  data(lineIndex)(columnIndex) = value.toInt}
    	}
    data
  }
  
  def getMaxProduct(nb: Int): Long = {
    
    val data = getData();
    val dimension = data.length
    var maxProduct = 0L
    
    def getIJMaxProduct(i: Int, j: Int): Long = {
      val ijRightProduct = (j to j + nb - 1).foldLeft(1L)((product, column) => product * data(i)(column))
      val ijBottomProduct = (i to i + nb - 1).foldLeft(1L)((product, line) => product * data(line)(j))
      val ijBottomRightProduct = (0 to nb - 1).foldLeft(1L)((product, diag) => product * data(i + diag)(j + diag))
      val ijTopRightProduct = (0 to nb - 1).foldLeft(1L)((product, diag) => product * data(i + nb - 1 - diag)(j + diag))
      ijRightProduct max ijBottomProduct max ijBottomRightProduct max ijTopRightProduct
    }
    
    (0 to dimension - nb).foreach(
        i =>
        (0 to dimension - nb).foreach(
           j => {
             maxProduct = maxProduct max getIJMaxProduct(i, j)
           }
        )
    )
    
    maxProduct
  }

}