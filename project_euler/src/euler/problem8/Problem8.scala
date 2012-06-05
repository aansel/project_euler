package euler.problem8
import scala.io.Source

object Problem8 {
  
  def main(args: Array[String]) {
    val t1 = System.currentTimeMillis()
	println(getGreatestProduct(5))
	val t2 = System.currentTimeMillis()
	println(t2 - t1)
  }
  
  def getGreatestProduct(length: Int) : Int = {
    Source.fromInputStream(getClass().getResourceAsStream("problem8.txt"))
      // Séparer au niveau de chaque zéro
	  .mkString.replace("\n", "").split("0")
	  // ne garder que les chaînes de longeur >= length
	  .filter(_.length() >= length)
	  .foldLeft(0)((bestProduct, chaine) => bestProduct max getGreatestProduct(chaine, length))
  }
  
  // Calculer le meilleur produit de length caractères qui se suivent parmi une chaîne de caractère
  // Peut mieux faire en évitant de reparcourir tous les caractères à chaque fois (substring)
  def getGreatestProduct(chaine: String, length: Int): Int = {
    (0 to chaine.length() - length).foldLeft(0)((bestProduct, i) => bestProduct max getProduct(chaine.substring(i, i + length)))
  }
  
  // Calculer le produit des digits d'une chaîne
  def getProduct(chaine: String): Int = {
    chaine.foldLeft(1)((product, caractere) => product * caractere.toString().toInt)
  }

}