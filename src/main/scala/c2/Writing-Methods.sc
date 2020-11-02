def square(in: Double): Double = {
  in * in
}

assert(square(2.0) == 4.0)
assert(square(3.0) == 9.0)
assert(square(-2.0) == 4.0)
assert(square(1.0) == 1.0)
assert(square(0.0) == 0.0)