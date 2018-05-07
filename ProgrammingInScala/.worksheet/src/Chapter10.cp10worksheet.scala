package Chapter10


object cp10worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(65); 

val a = List(1, 2, 3);System.out.println("""a  : List[Int] = """ + $show(a ));$skip(22); 
val b = List(4, 5, 6);System.out.println("""b  : List[Int] = """ + $show(b ));$skip(18); val res$0 = 


b ::: a.reverse;System.out.println("""res0: List[Int] = """ + $show(res$0))}
  
  
                                    
                                    
  
}
