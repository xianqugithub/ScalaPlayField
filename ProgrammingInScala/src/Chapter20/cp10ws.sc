package Chapter20

object cp10ws {

   case class Rectangle(width: Int, height: Int)
   
   implicit class RectangleMaker(width: Int) {
   	def x(height: Int) = Rectangle(width, height)
   }
   
   3 x 4                                          //> res0: Chapter20.cp10ws.Rectangle = Rectangle(3,4)
  	

}