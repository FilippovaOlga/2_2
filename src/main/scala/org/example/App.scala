package org.example
import scala.::
import scala.io.StdIn.readLine
import scala.io.StdIn.readDouble

/**
 * @author ${user.name}
 */
object App {
  def main(args : Array[String]) {
    //3.a
    val str2 = "Hello Scala!"
    println( str2 )
    println( str2.reverse )
    println( str2.toLowerCase )
    println( str2.replace("!","") )
    println( str2.replace("!"," ") + "and goodbye python!")

    //3.b
    print("Enter year salary: ")
    var salary = readDouble().toInt
    print("Enter bonus rate: ")
    var bonus = readDouble().toFloat
    print("Enter food compensation: ")
    var food = readDouble().toInt
    println( (salary*(1+bonus)+food)* 0.87 / 12.0)

    //3.c
    var arrSalaries = scala.collection.mutable.MutableList(100, 150, 200, 80, 120, 75)
    var avgSalary = arrSalaries.sum/arrSalaries.size.toFloat
    println(f"Средний оклад = $avgSalary%.2f")
    arrSalaries.foreach(println)

    //3.d
    println(f"\nОтклонение от среднего значение оклада $avgSalary%.2f:")
    for (curSal <- arrSalaries) {
      val otkl = (curSal - avgSalary) / avgSalary * 100
      println(f" Отклонение: $otkl%.2f \t($curSal)")
    }
    arrSalaries += (arrSalaries.apply(3)-(arrSalaries.apply(3)-avgSalary)*0.8).toInt
    println(s"Самая высокая зарплата =  ${arrSalaries.max}")
    println(s"Самая низкая зарплата =  ${arrSalaries.min}")
    avgSalary = arrSalaries.sum / arrSalaries.size.toFloat
    println(f"Средний оклад = $avgSalary%.2f ")

    //3.e
    arrSalaries.++= (List(300, 90))
    arrSalaries=arrSalaries.sorted
    println(s"Отсортированный массив")
    arrSalaries.foreach(println)

    //3.f
    println(s"\nВставка в отсортированный массив")
    val newSal:Int=130
    arrSalaries=arrSalaries.filter(_.<(newSal)).+=(newSal).union(arrSalaries.filter(_.>=(newSal)))
    arrSalaries.foreach(println)

    //3.g
    println(s"\n Middle")
    for (n <- arrSalaries.indices)
    {
      //println(n)
      if ((arrSalaries.apply(n)>=120) && (arrSalaries.apply(n)<=200)) println(f" $n middle (${arrSalaries.apply(n)})")
    }

    //3.h
    println(s"\n Индексация")
    for (n <- arrSalaries.indices) {
      arrSalaries(n)=(arrSalaries(n)*1.07).toInt
    }
    println(arrSalaries)
  }
}
