if(1 < 2) "Yes" else "No"

if(1 < 2)
  println("Yes")
else
  println("No")

{ 1; 2; 3 }

{
  println("This is a side-effect")
  println("This is a side-effect as well")
  3
}

def name: String = {
  val title = "Professor"
  val name = "Funkenstein"
  title + " " + name
}

name

if(1 > 2) "alien" else "predator"
// Type will be String, value is "predator"

if(1 > 2) "alien" else 2001
// Type will be Integer, value is 2001
// Actually, the type is Any, since Any is
// the common supertype between the values
// Alien and 2001

if(false) "hello"
// Any type, Unit type