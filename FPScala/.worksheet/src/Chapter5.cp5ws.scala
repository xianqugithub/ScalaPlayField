package Chapter5

import Stream._

object cp5ws {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(74); val res$0 = 
  
  fibs.take(5).toList;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(34); val res$1 = 
  
  fibsViaUnfold.take(5).toList;System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(28); val res$2 = 
  
  from(1).take(9).toList;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(34); val res$3 = 
  fromViaUnfold(1).take(9).toList;System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(40); val res$4 = 
  
  constant("youyou").take(10).toList;System.out.println("""res4: List[String] = """ + $show(res$4));$skip(46); val res$5 = 
  constantViaUnfold("youyou").take(10).toList;System.out.println("""res5: List[String] = """ + $show(res$5))}
  
  
   

}
