sealed trait Traffic_Light
case object Red_Traffic_Light
  extends Traffic_Light
case object Yellow_Traffic_Light
  extends Traffic_Light
case object Green_Traffic_Light
  extends Traffic_Light

sealed trait Calculation
final case class Succeed(result: Int) extends Calculation
final case class Failure(reason: String) extends Calculation

sealed trait Source
case object Well extends Source
case object Spring extends Source
case object Tap extends Source

final case class Bottled_Water(size: Int,
                               source: Source,
                               carbonated: Boolean)

Bottled_Water(10, Well, carbonated = true)
