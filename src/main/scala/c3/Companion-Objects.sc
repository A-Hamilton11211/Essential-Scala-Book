class Timestamp(val seconds: Long)

object Timestamp {
  def apply(hours: Int,
            minutes: Int,
            seconds: Int): Timestamp =
    new Timestamp(hours*60*60 + minutes*60 + seconds)
}

Timestamp(1, 1, 1).seconds

class Person(val firstName: String,
            val secondName: String){
  def name = s"$firstName $secondName"
}

object Person {
  def apply(name: String): Person = {
    val parts = name.split(" ")
    new Person(parts(0), parts(1))
  }
}

Person("John Doe").firstName

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



