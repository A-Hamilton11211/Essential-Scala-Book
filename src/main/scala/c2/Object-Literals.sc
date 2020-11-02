object Test {}

Test

object Test2 {
  def name: String = "Probably the best object ever"
}

Test2.name

object Test3 {
  def hello(name: String) =
    "Hello " + name
}

Test3.hello("Noel")

object Test4 {
  val name = "Noel"
  def hello(other: String) =
    name + "says hi to" + other
}

Test4.hello("Dave")

object Test7 {
  val simpleField = {
    println("Evaluating simpleField")
    42
  }
  def noParameterMethod = {
    println("Evaluating noParameterMethod")
    42
  }
}

Test7

Test7.simpleField

Test7.simpleField

Test7.noParameterMethod

Test7.noParameterMethod

object Cat1 {
  val name: String = "Oswald"
  val color: String = "Black"
  val food: String = "Milk"
}

Cat1.name

object Cat2 {
  val name: String = "Henderson"
  val color: String = "Ginger"
  val food: String = "Chips"
}

Cat2.color

object Cat3 {
  val name: String = "Quentin"
  val color: String = "Tabby and White"
  val food: String = "Curry"
}

Cat3.food

object calc {
  def square(value: Double): Double = {
    value * value
  }
  def cube(value: Double): Double= {
    square(value) * value
  }
}

calc.cube(2.0)

object calc2 {
  def square(value: Int)= {
    value * value
  }
  def cube(value: Int)= {
    square(value) * value
  }

  def square(value: Double)= {
    value * value
  }
  def cube(value: Double)= {
    square(value) * value
  }
}

calc2.cube(3)
calc2.cube(2.0)

object argh {
  def a = {
    println("a")
    1
  }

  val b = {
    println("b")
    a + 2
  }

  def c = {
    println("c")
    a
    b + "c"
  }
}

argh.c + argh.b + argh.a

object person {
  val firstName: String = "Ali"
  val lastName: String = "G"
}

object alien {
  def greet(p: person.type): String = {
    "Greetings, " + p.firstName + " " + p.lastName
  }
}

alien.greet(person)

