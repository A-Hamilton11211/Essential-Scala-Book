import java.util.Date

sealed trait Visitor {
  def id: String
  def createdAt: Date
  def age: Long = new Date().getTime - createdAt.getTime
}

final case class Anonymous(id: String,
                     createdAt: Date = new Date()
                    ) extends Visitor

final case class User(id: String,
                email: String,
                createdAt: Date = new Date()
               ) extends Visitor

def missingCase(v: Visitor) =
  v match {
    case User(_, _, _) => "Got a user"
  }

missingCase(User("123", "@", new Date()))

sealed trait Shape{
  def sides: Int
  def perimeter: Double
  def area: Double
}

case class Circle(radius: Double) extends Shape{
  val area = math.Pi * radius * radius
  val sides = 1
  val perimeter = radius * 2 * math.Pi
}

case class Rectangle(height: Double,
                     width: Double) extends Shape{
  val area = height * width
  val sides = 4
  val perimeter = 2*height + 2*width
}

object Draw {
  def apply(s: Shape): String = {
    s match {
      case Circle(radius) =>
        s"A circle with a radius of $radius"
      case Rectangle(height, width) =>
        s"A rectangle with a heght of $height and a width of $width"
    }
  }
}

Draw(Circle(10))
Draw(Rectangle(3, 4))

sealed trait DivisionResult
final case object Infinite extends DivisionResult
final case class Finite(i: Int) extends DivisionResult

object divide{
  def apply(i1: Int, i2: Int):DivisionResult =
    if(i2 == 0) Infinite else Finite(i1/i2)
}

divide(1, 0)