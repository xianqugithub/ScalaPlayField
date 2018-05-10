package Chapter4

//Exercise 4.1
sealed trait Option[+A] {
  
  // Pattern matching
  def map[B](f: A => B): Option[B] =
    this match {
    case Some(a) => Some(f(a))
    case None => None
  }
  
  def getOrElse[B >: A](default: => B): B = 
    this match {
    case Some(a) => a
    case None => default
  }
  
  // Non-pattern matching 
  def flatMap[B](f: A => Option[B]): Option[B] =
    this.map(f).getOrElse(None)
  
  def orElse[B >: A](ob: => Option[B]): Option[B] =
    this.map(Some(_)).getOrElse(ob)
    
  def filter(f: A => Boolean): Option[A] =
    this.flatMap(a => (if (f(a)) Some(a) else None))

} 


case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]

