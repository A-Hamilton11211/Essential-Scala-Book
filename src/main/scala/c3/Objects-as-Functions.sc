class Adder(amount: Int) {
  def apply(in: Int): Int = in + this.amount
}

val add3 = new Adder(3)

add3.apply(2)

add3(4)

/*
How close does function application syntax get
us to creating truly reusable objects to do
computations for us?  What are we missing?

 Function application syntax enables us to
 use classes and objects more like variables,
 allowing us to pass functions as arguments
 to other functions (currying).  But
 according to the text we need types to
 properly abstract across values.  In other
 words, we need a set of generic function types
 that define what sort of function we have and
 how it should be used
 */