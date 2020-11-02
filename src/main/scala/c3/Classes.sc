class Person {
  val firstName = "Noel"
  val lastName = "Welsh"
  def name = firstName + " " + lastName
}

val noel = new Person

noel.firstName

noel

val newNoel = new Person

val anotherNoel = new Person

object alien {
  def greet(p: Person) =
    "Greetings, " + p.firstName + " " + p.lastName
}

alien.greet(noel)

alien.greet(newNoel)

class Person(first: String, last: String) {
  val firstName = first
  val lastName = last
  def name = firstName + " " + lastName
}

val dave = new Person("Dave", "Gurnell")

dave.name

class Person(val firstName: String, val lastName: String) {
  def name = firstName + " " + lastName
}

new Person("Dave", "Gurnell").firstName

new Person(lastName = "Last", firstName = "First")

def greet(firstName: String = "Some",
          lastName: String = "Body") = {
  "Greetings, " + firstName + " " + lastName + "!"
}

greet("Busy")

greet(lastName = "Dave")

def badness = throw new Exception("Error")

def otherbadness = null

val bar = if(true) 123 else badness

val baz = if(false) "it worked" else otherbadness

class Cat(val name: String, val colour: String, val food: String)

val oswald = new Cat(name = "Oswald", colour = "Black", food = "Milk")
val henderson = new Cat(name = "Henderson", colour = "Ginger", food = "Chips")
val quentin = new Cat(name = "Quentin", colour = "Tabby and white", food = "Curry")

object ChipShop {
  def willServe(c: Cat): Boolean = {
    if(c.food == "Chips")
      true
    else
      false
  }
}

ChipShop.willServe(henderson)
ChipShop.willServe(quentin)

class Director(val firstName: String, val lastName: String, val yearOfBirth: Int){
  def name = s"$firstName $lastName"
}

class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double,
           val director: Director) {
  def directorsAge: Int = yearOfRelease - director.yearOfBirth
  def isDirectedBy(d: Director): Boolean = {
    d == this.director
  }
  def copy(name: String = this.name,
           yearOfRelease: Int = this.yearOfRelease,
           imdbRating: Double = this.imdbRating,
           director: Director = this.director): Film = {
    new Film(name, yearOfRelease, imdbRating, director)
  }
}

val eastwood          = new Director("Clint", "Eastwood", 1930)
val mcTiernan         = new Director("John", "McTiernan", 1951)
val nolan             = new Director("Christopher", "Nolan", 1970)
val someBody          = new Director("Just", "Some Body", 1990)

val memento           = new Film("Memento", 2000, 8.5, nolan)
val darkKnight        = new Film("Dark Knight", 2008, 9.0, nolan)
val inception         = new Film("Inception", 2010, 8.8, nolan)

val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
val outlawJoseyWales  = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
val unforgiven        = new Film("Unforgiven", 1992, 8.3, eastwood)
val granTorino        = new Film("Gran Torino", 2008, 8.2, eastwood)
val invictus          = new Film("Invictus", 2009, 7.4, eastwood)

val predator          = new Film("Predator", 1987, 7.9, mcTiernan)
val dieHard           = new Film("Die Hard", 1988, 8.3, mcTiernan)
val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

eastwood.yearOfBirth
dieHard.director.name
invictus.isDirectedBy(nolan)

highPlainsDrifter.copy(name = "L'homme des hautes plaines")
thomasCrownAffair.copy(yearOfRelease = 1968,
  director = new Director("Norman", "Jewison", 1926))
inception.copy().copy().copy()

class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

class Counter(val i: Int){
  def inc: Counter = inc()
  def dec: Counter = dec()
  def inc (add: Int = 1): Counter = new Counter(i + add)
  def dec (minus: Int = 1): Counter = new Counter(i - minus)
  def count: Int = this.i
  def adjust(a: Adder): Counter = new Counter(a.add(this.i))
}

new Counter(10).inc.dec.inc.inc(10).count

val a = new Adder(2)
new Counter(10).adjust(a).count
