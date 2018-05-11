package Chapter5

import Stream._

object cp5ws {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(91); val res$0 = 
  
  Stream(1,2,3).tails.toList(0).toList;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(39); val res$1 = 
  Stream(1,2,3).tails.toList(1).toList;System.out.println("""res1: List[Int] = """ + $show(res$1))}
  
  
   

}
