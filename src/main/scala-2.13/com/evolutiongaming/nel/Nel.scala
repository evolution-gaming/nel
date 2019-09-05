package com.evolutiongaming.nel

import scala.annotation.unchecked.uncheckedVariance
import scala.collection.{BuildFrom, Factory, IterableOnce, immutable, mutable}
import scala.language.higherKinds


/**
  * Non empty list
  */
final case class Nel[+A](head: A, tail: List[A]) {

  def toList: List[A] = head :: tail

  def foreach[B](f: A => B): Unit = {
    f(head)
    tail foreach f
  }

  def map[B](f: A => B): Nel[B] = Nel(f(head), tail.map(f))

  def ++[B >: A](xs: Nel[B]): Nel[B] = this ++ xs.toList

  def ++[B >: A](xs: IterableOnce[B]): Nel[B] = {
    Nel(head, tail ++ xs)
  }

  def +:[B >: A](a: B): Nel[B] = Nel(a, head :: tail)

  def :+[B >: A](a: B): Nel[B] = Nel(head, tail :+ a)

  def flatMap[B](f: A => Nel[B]): Nel[B] = f(head) ++ tail.flatMap(f andThen (_.toList))

  def ::[B >: A](a: B): Nel[B] = Nel(a, head :: tail)

  def :::[AA >: A](xs: List[AA]): Nel[AA] = xs match {
    case x :: xs => Nel(x, xs ::: head :: tail)
    case Nil     => this
  }

  def filter(p: A => Boolean): List[A] = {
    val ftail = tail.filter(p)
    if (p(head)) head :: ftail
    else ftail
  }

  def filterNot(p: A => Boolean): List[A] = {
    val ftail = tail.filterNot(p)
    if (p(head)) ftail
    else head :: ftail
  }

  def concat[B >: A](other: Nel[B]): Nel[B] = Nel(head, tail ::: other.toList)

  def find(p: A => Boolean): Option[A] = {
    if (p(head)) Some(head)
    else tail.find(p)
  }

  def exists(p: A => Boolean): Boolean = p(head) || tail.exists(p)

  def forall(p: A => Boolean): Boolean = p(head) && tail.forall(p)

  def contains[B >: A](a: B): Boolean = exists(_ == a)

  def foldLeft[B](z: B)(f: (B, A) => B): B = {
    tail.foldLeft(f(z, head))(f)
  }

  def foldRight[B](z: B)(f: (A, B) => B): B = {
    toList.foldRight(z)(f)
  }

  def reduceLeft[B >: A](f: (B, A) => B): B = {
    tail.foldLeft[B](head)(f)
  }

  def reduceRight[B >: A](f: (A, B) => B): B = {
    toList.reduceRight(f)
  }

  def reverse: Nel[A] = {
    val result = toList.reverse
    Nel(result.head, result.tail)
  }

  def mkString(start: String, sep: String, end: String): String = toList.mkString(start, sep, end)

  def mkString(sep: String): String = toList.mkString(sep)

  def mkString: String = toList.mkString

  def to[Coll](factory: Factory[A, Coll]): Coll = factory.fromSpecific(this.toList)

  def toMap[K, V](implicit ev: A <:< (K, V)): Map[K, V] = {
    val b = Map.newBuilder[K, V]
    for {x <- this} b += x
    b.result()
  }

  def distinct: Nel[A] = {
    val distinct = toList.distinct
    Nel(distinct.head, distinct.tail)
  }

  def size: Int = length

  def length: Int = 1 + tail.length

  def count(f: A => Boolean): Int = toList.count(f)

  def collect[B](pf: PartialFunction[A, B]): List[B] = toList collect pf

  def collectFirst[B](pf: PartialFunction[A, B]): Option[B] = toList collectFirst pf

  def last: A = tail.lastOption getOrElse head

  def unzip[A1, A2](implicit asPair: A => (A1, A2)): (Nel[A1], Nel[A2]) = {
    val (h1, h2) = asPair(head)
    val (t1, t2) = tail.unzip
    (Nel(h1, t1), Nel(h2, t2))
  }

  def unzip3[A1, A2, A3](implicit asTriple: A => (A1, A2, A3)): (Nel[A1], Nel[A2], Nel[A3]) = {
    val (h1, h2, h3) = asTriple(head)
    val (t1, t2, t3) = tail.unzip3
    (Nel(h1, t1), Nel(h2, t2), Nel(h3, t3))
  }

  def iterator: Iterator[A] = toList.iterator

  def groupBy[K](f: A => K): Map[K, Nel[A]] = {
    val map = mutable.Map.empty[K, mutable.Builder[A, List[A]]]
    for {elem <- this} {
      val key = f(elem)
      val builder = map.getOrElseUpdate(key, List.newBuilder)
      builder += elem
    }
    val builder = immutable.Map.newBuilder[K, Nel[A]]
    for {(k, v) <- map} {
      builder += ((k, Nel.unsafe(v.result)))
    }

    builder.result
  }

  def flatten[B](implicit asTraversable: A => IterableOnce[B]): List[B] = toList.flatten

  def reverse_:::[B >: A](list: List[B]): Nel[B] = {
    list.foldLeft[Nel[B]](this) { (bs, b) => b :: bs }
  }

  def reverseMap[B](f: A => B): Nel[B] = {
    tail.foldLeft(Nel(f(head))) { (bs, a) => f(a) :: bs }
  }

  override def toString: String = s"$productPrefix(${ toList mkString ", " })"
}

object Nel {

  def apply[T](head: T, tail: T*): Nel[T] = Nel(head, tail.toList)

  def opt[T](iter: Iterable[T]): Option[Nel[T]] = {
    PartialFunction.condOpt(iter.toList) { case head :: tail => Nel(head, tail) }
  }

  def unsafe[T](iter: Iterable[T]): Nel[T] = {
    val list = iter.toList
    Nel(list.head, list.tail)
  }

  def ::[T](head: T): Nel[T] = Nel(head)
}
