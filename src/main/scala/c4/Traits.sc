import java.util.Date

trait Visitor {
  def id: String
  def createdAt: Date
  def age:Long = new Date().getTime - createdAt.getTime
}

case class Anonymous(id: String,
                     createdAt: Date = new Date()
                    ) extends Visitor

case class User(id: String,
                email: String,
                createdAt: Date = new Date()
               ) extends Visitor

def older(v1: Visitor, v2: Visitor): Boolean =
  v1.createdAt.before(v2.createdAt)

older(Anonymous("1"), User("2", "test@example.com"))

trait Feline{
  def colour: String
  def sound: String = "meow"
}

trait BigCat extends Feline{
  override val sound = "roar"
}

case class Cat(colour: String,
               favourite_food: String
              ) extends Feline

case class Tiger(colour: String
                ) extends BigCat

case class Panther(colour: String
                  ) extends BigCat

case class Lion(colour: String,
                maneSize: Int
               ) extends BigCat

Lion("Tawny", 75).sound

trait Shape{
  def sides: Int
  def perimeter: Double
  def area: Double
}

sealed trait Rectangular extends Shape {
  def height: Double
  def width: Double
  val sides = 4
  def perimeter = 2*height + 2*width
  def area = height*width
}

case class Circle(radius: Double) extends Shape{
  val area = math.Pi * radius * radius
  val sides = 1
  val perimeter = radius * 2 * math.Pi
}

case class Square(side: Double) extends Rectangular {
  val height = side
  val width = side
}

case class Rectangle(height: Double,
                     width: Double) extends Rectangular
