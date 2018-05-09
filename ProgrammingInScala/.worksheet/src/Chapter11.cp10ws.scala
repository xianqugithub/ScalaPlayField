package Chapter11

object cp10ws {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(113); 
	
	def error(message: String): Nothing =
		throw new RuntimeException(message);System.out.println("""error: (message: String)Nothing""");$skip(100); 



  def divide(x: Int, y: Int): Int =
  		if (y != 0) x / y
  		else error("can't divide by zero");System.out.println("""divide: (x: Int, y: Int)Int""");$skip(28); 
  		
  val a = divide(10,1);System.out.println("""a  : Int = """ + $show(a ));$skip(23); 
  val b = divide(10,0);System.out.println("""b  : Int = """ + $show(b ))}
  
 
}
