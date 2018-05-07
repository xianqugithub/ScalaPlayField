package Chapter20

object cp10ws {

   case class Rectangle(width: Int, height: Int)
   
   implicit class RectangleMaker(width: Int) {
   	def x(height: Int) = Rectangle(width, height)
   };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(203); val res$0 = 
   
   3 x 4;System.out.println("""res0: Chapter20.cp10ws.Rectangle = """ + $show(res$0))}
  	

}
