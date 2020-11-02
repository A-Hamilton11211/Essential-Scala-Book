case class Person(firstName: String,
                  lastName: String) {
  def name = s"$firstName $lastName"
}

/*
object Person {
  def apply(name: String): Person = {
    val parts = name.split(" ")
    new Person(parts(0), parts(1))
  }
}

Person("Irvine Welsh")
*/

val dave = new Person("Dave", "Gurnell")

Person

new Person("Noel", "Welsh")
  .equals(new Person("Noel", "Welsh"))

Person("Noel", "Welsh") == Person("Noel", "Welsh")

dave.copy()

dave.copy(firstName = "Dave2")

dave.copy(lastName = "Gurnell2")

case object Citizen {
  def firstName = "John"
  def lastName = "Doe"
  def name = s"$firstName $lastName"
}

Citizen.toString

case class Cat(colour: String,
               food: String)

/*
OLD CODE WITHOUT CASE CLASSES:

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

object Director {
  def apply(firstName: String,
            lastName: String,
            yearOfBirth: Int): Director =
    new Director(firstName, lastName, yearOfBirth)

  def older(d1: Director, d2: Director): Director =
    if(d1.yearOfBirth > d2.yearOfBirth)
      d1
    else if(d1.yearOfBirth < d2.yearOfBirth)
      d2
    else {
      println("Directors born in same year")
      d1
    }
}

object Film {
  def apply(name: String,
            yearOfRelease: Int,
            imdbRating: Double,
            director: Director): Film =
    new Film(name, yearOfRelease, imdbRating, director)

  def highestRating(f1: Film,
                    f2: Film) =
    if(f1.imdbRating > f2.imdbRating)
      f1
    else if (f1.imdbRating < f2.imdbRating)
      f2
    else {
      println("Films have same rating")
      f1
    }

  def oldestDirectorAtTheTime(f1: Film,
                              f2: Film): Director =
    if(f1.directorsAge > f2.directorsAge)
      f1.director
    else if(f1.directorsAge < f2.directorsAge)
      f2.director
    else {
      println("Film's directors are same age")
      f1.director
    }
}
*/

case class Director(firstName: String,
                    lastName: String,
                    yearOfBirth: Int) {
  def name = s"$firstName $lastName"
  def older(d1: Director,
            d2: Director): Director =
    if(d1.yearOfBirth < d2.yearOfBirth)
      d1
    else
      d2
}

case class Film(name: String,
                yearOfRelease: Int,
                imdbRating: Double,
                director: Director) {
  def directorsAge: Int = yearOfRelease - director.yearOfBirth
  def isDirectedBy(d: Director): Boolean = {
    d == this.director
  }
  def highestRating(f1: Film,
                    f2: Film) =
    if(f1.imdbRating > f2.imdbRating)
      f1
    else if (f1.imdbRating < f2.imdbRating)
      f2
    else {
      println("Films have same rating")
      f1
    }

  def oldestDirectorAtTheTime(f1: Film,
                              f2: Film): Director =
    if(f1.directorsAge > f2.directorsAge)
      f1.director
    else if(f1.directorsAge < f2.directorsAge)
      f2.director
    else {
      println("Film's directors are same age")
      f1.director
    }
}

/*
OLD COUNTER CODE

class Counter(val i: Int){
  def inc: Counter = inc()
  def dec: Counter = dec()
  def inc (add: Int = 1): Counter = new Counter(i + add)
  def dec (minus: Int = 1): Counter = new Counter(i - minus)
  def count: Int = this.i
  def adjust(a: Adder): Counter = new Counter(a.add(this.i))
}
*/

case class Counter(i: Int = 0) {
  def inc(add: Int = 1): Counter =  copy(i + add)
  def dec(minus: Int = 1): Counter = copy(i - minus)
}

