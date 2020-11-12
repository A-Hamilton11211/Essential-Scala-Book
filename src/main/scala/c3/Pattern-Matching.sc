case class Person(firstName: String,
                  lastName: String)

object Stormtrooper {
  def inspect(p: Person): String =
    p match {
      case Person("Luke", "Skywalker") => "Stop, rebel scum!"
      case Person("Han", "Solo") => "Stop, rebel scum!"
      case Person(first, last) => s"Move along $first"
    }
}

Stormtrooper.inspect((Person("Noel", "Welsh")))

Stormtrooper.inspect(Person("Han", "Solo"))

case class Cat(food: String,
               colour: String)

object ChipShop {
  def willServe(c: Cat) =
    c match {
      case Cat("Chips", _) => true
      case Cat(_, _) => false
    }
}

ChipShop.willServe(Cat("Chips", "Ginger"))

ChipShop.willServe(Cat("Curry", "Black"))

