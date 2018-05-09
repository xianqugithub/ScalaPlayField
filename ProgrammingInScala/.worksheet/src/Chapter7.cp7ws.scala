package Chapter7

object cp7ws {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(202); 
  def makeRowSeq(row: Int) =
    for (col <-1 to 10) yield {
    		val prod = (row * col).toString
    		val padding = " " * (4 - prod.length)
    		padding + prod
    };System.out.println("""makeRowSeq: (row: Int)scala.collection.immutable.IndexedSeq[String]""");$skip(54); 
  
  def makeRow(row: Int) = makeRowSeq(row).mkString;System.out.println("""makeRow: (row: Int)String""");$skip(132); 
  
  def multiTable() = {
  		val tableSeq =
  			for (row <- 1 to 10)
  			yield makeRow(row)
  			
 		tableSeq.mkString("\n")
  };System.out.println("""multiTable: ()String""");$skip(26); 
  
  val t = multiTable();System.out.println("""t  : String = """ + $show(t ))}
 
  
}
