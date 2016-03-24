


object Main {
  /**
  * class BoolLike a where
  *     fromBoolLike :: a -> Bool
  */
  trait BoolLike[A]  {
    def fromBoolLike(a:A): Boolean
  }

  /**
    * instance BoolLike Int where
    *     fromBoolLike = (0 /=)
    */
  implicit def IntBoolLike = new BoolLike[Int] {
    def fromBoolLike(a:Int): Boolean = a != 0
  }

  /**
    * instance BoolLike (Maybe a) where
    *     fromBoolLike Nothing  = False
    *     fromBoolLike (Just _) = True
    */
  /*
  implicit def OptionBoolLike[A] = new BoolLike[Option[A]] {
    def fromBoolLike(a:Option[A]): Boolean = a match {
      case None => false
      case _ => true
    }
  }
  */

  /**
    * instance BoolLike Bool where
    *     fromBoolLike x = x
    */
  implicit def BoolBoolLike = new BoolLike[Boolean] {
    override def fromBoolLike(a:Boolean) = a
  }

  def fromBoolLike[T](x: T)(implicit instance: BoolLike[T]) = instance.fromBoolLike(x)

  def main(args: Array[String]): Unit = {
    println(fromBoolLike(0))
    println(fromBoolLike(1))
    //println(fromBoolLike(None))
    //println(fromBoolLike(Some("")))
    //println(fromBoolLike(Some(false)))
    println(fromBoolLike(true))
    println(fromBoolLike(false))
  }
}
