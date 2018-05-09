package Chapter10

import Monoid._

trait Foldable[F[_]] {
  def foldRight[A, B](as: F[A])(z: B)(f: (A,B) => B): B 
    
  def foldLeft[A, B](as: F[A])(z: B)(f: (B,A) => B): B
  
  def foldMap[A, B](as: F[A])(f: A => B)(mb: Monoid[B]): B =
    foldRight(as)(mb.zero)((a, b) => mb.op(f(a),b))
  
  def concatenate[A](as: F[A])(m: Monoid[A]): A =
    foldLeft(as)(m.zero)(m.op)
    
  // Exercise 10.15
  def toList[A](fa:F[A]): List[A] = 
    foldRight(fa)(List[A]())(_::_)    
}

// Exercise 10.12
object FoldableList extends Foldable[List] {
  def foldRight[A, B](as: List[A])(z: B)(f: (A,B) => B): B =
     as.foldRight(z)(f)
  
  def foldLeft[A,B](as: List[A])(z:B)(f: (B, A) => B): B =
    as.foldLeft(z)(f)
}

object FoldableIndexedSeq extends Foldable[IndexedSeq] {
  def foldRight[A, B](as: IndexedSeq[A])(z: B)(f: (A,B) => B): B =
     as.foldRight(z)(f)
  
  def foldLeft[A,B](as: IndexedSeq[A])(z:B)(f: (B, A) => B): B =
    as.foldLeft(z)(f)
}

object FoldableStream extends Foldable[Stream] {
  def foldRight[A, B](as: Stream[A])(z: B)(f: (A,B) => B): B =
     as.foldRight(z)(f)
  
  def foldLeft[A,B](as: Stream[A])(z:B)(f: (B, A) => B): B =
    as.foldLeft(z)(f)
}

object FoldableOption extends Foldable[Option] {
  def foldRight[A, B](as: Option[A])(z: B)(f: (A,B) => B): B =
     as match {
    case None => z
    case Some(a) => f(a,z) 
  }
  
  def foldLeft[A,B](as: Option[A])(z:B)(f: (B, A) => B): B =
     as match {
    case None => z
    case Some(a) => f(z, a)
  } 
  
}

