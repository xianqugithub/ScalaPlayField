package Chapter4

case class Person(name: Name, age: Age)
sealed class Name(val value:String)
sealed class Age(val value:Int)
