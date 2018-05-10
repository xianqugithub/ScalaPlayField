package Chapter4

object cp4ws {
  //Exercise 4.2
  
  def mean(xs: Seq[Double]): Option[Double] =
  		if (xs.isEmpty) None
  		else Some(xs.sum / xs.length)
  
  def variance(xs: Seq[Double]): Option[Double] =
    mean(xs) flatMap (m => mean(xs.map(x => Math.pow(x-m, 2))))
  
  // Exercise 4.3 Pattern matching
  def map2[A,B,C](a: Option[A], b: Option[B])(f: (A,B) => C): Option[C] = (a, b) match {
  		case (None, _) => None
  		case (_, None) => None
  		case (Some(x), Some(y)) => Some(f(x,y))
  }
  
  // Option
  // Exercise 4.4, base case is Some(Nil) (Nil extends a list of nothing)
  // Implementation based on map2
  // Not an eager stop ? Still traverse the rest of the list even there is already none?
  // Answered by 4.8? Too hard right now for me
 
  def sequence[A](a: List[Option[A]]): Option[List[A]] =
    a.foldRight[Option[List[A]]](Some(Nil))((x, y) => map2(x,y)(_::_))
    
    
    
  // Exercise 4.5
  def traverse[A, B](a: List[A]) (f: A => Option[B]): Option[List[B]] =
  		a.foldRight[Option[List[B]]](Some(Nil))((x, y) => map2(f(x),y)(_::_))
    
    
  // Either
  // Exercise 4.7
  def sequence[E, A](es: List[Either[E, A]]) : Either[E, List[A]] =
    es.foldRight[Either[E, List[A]]](Right(Nil))((x, y) => x.map2(y)(_::_))
  
  def traverse[E, A, B](as: List[A])(f: A => Either[E, B]): Either[E, List[B]] =
    as.foldRight[Either[E, List[B]]](Right(Nil))((x, y) => f(x).map2(y)(_::_))
    
    
  def mkName(name: String): Either[String, Name] =
  		if (name == "" || name == null) Left("Name is empty.")
  		else Right(new Name(name))
  
  def mkAge(age: Int): Either[String, Age] =
  		if (age < 0) Left("Age is out of range.")
  		else Right(new Age(age))
  		
  def mkPerson(name: String, age: Int): Either[String, Person] =
    mkName(name).map2(mkAge(age))(Person(_, _))
  
  
  
}