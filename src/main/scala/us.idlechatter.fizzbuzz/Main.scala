package us.idlechatter.fizzbuzz

case class FizzBuzz(fizz: Boolean, buzz: Boolean)

object FizzBuzz {
  def make_new(num: Int): FizzBuzz = new FizzBuzz (
    multiple_of_3_?(num),
    multiple_of_5_?(num)
  )

  private def multiple_of_3_?(num: Int) = num % 3 == 0

  private def multiple_of_5_?(num: Int) = num % 5 == 0

  def both_fizz_and_buzz(num: Int): Unit = printf("%3d: fizzbuzz%n", num)

  def fizz_with_no_buzz(num: Int): Unit = printf("%3d: fizz%n", num)

  def buzz_with_no_fizz(num: Int): Unit = printf("%3d: buzz%n", num)

  def neither_fizz_nor_buzz(num: Int): Unit = printf("%3d: ...%n", num)
}

object Main {
  def main(args: Array[String]): Unit = fizzbuzz()

  private def fizzbuzz() = {
    import FizzBuzz._
    for (number <- 1 to 100) {
      make_new(number) match {
        case instance @ FizzBuzz(true, true)  => both_fizz_and_buzz(number)
        case instance @ FizzBuzz(true, false) => fizz_with_no_buzz(number)
        case instance @ FizzBuzz(false, true) => buzz_with_no_fizz(number)
        case _ => neither_fizz_nor_buzz(number)
      }
    }
  }
}