import java.util.*

fun main() {
    //1.
    sum(2, 3)

    //2.
    val daysOfWeek = listOf<String>("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    for (day: String in daysOfWeek) {
        print("$day ")
    }
    println()
    println(daysOfWeek.filter { day -> day.startsWith('T') })
    println(daysOfWeek.filter { day -> day.contains('e') })
    println(daysOfWeek.filter { day -> day.length == 6 })
    //3.
    checkPrimesInRange(1, 10)

    //4.
    val encoded = messageCoding("Test", encode)
    println("Encoded: $encoded")
    val decoded = messageCoding(encoded, decode)
    println("Decoded: $decoded")

    //5.
    val listOfNums: List<Int> = (1..20).toList()
    println(even(listOfNums))

    //6.
    println(listOfNums.map { it * 2 })
    println(daysOfWeek.map { day -> day.uppercase() })
    println(daysOfWeek.map { day -> day[0].lowercase() })
    println(daysOfWeek.map { day -> day.length })
    println(daysOfWeek.map { day -> day.length }.average())

    //7.
    val daysWithoutN: List<String> = daysOfWeek.filter { day -> !day.contains('n') }
    daysWithoutN.withIndex().forEach { (index, day) ->
        println("Item at $index is $day")
    }
    println(daysWithoutN.sorted())

    //8.
    val randomNums = List(10) { (0..100).random() }
    println(randomNums.sorted())
    println("Any even?: ${randomNums.any { it % 2 == 0 }}")
    println("All even?: ${randomNums.all { it % 2 == 0 }}")
    println("Average: ${randomNums.average()}")
    //with forEach
    var sum: Double = 0.0
    randomNums.forEach { num -> sum += num }
    println(sum / (randomNums.size))
}

fun sum(val1: Int, val2: Int) {
    println("$val1 + $val2 = ${val1 + val2}")
}

fun prime(num: Int): Boolean {
    if (num == 0 || num == 1) {
        return false
    }
    for (i in 2..(num / 2)) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}

fun checkPrimesInRange(from: Int, to: Int) {
    for (num in from..to) {
        println("$num: ${prime(num)}")
    }
}

val encode: (String) -> String = { str -> str.map { c -> c - 1 }.joinToString("") }

val decode: (String) -> String = { str -> str.map { c -> c + 1 }.joinToString("") }

fun messageCoding(msg: String, func: (String) -> String): String = func(msg)

fun even(listOfNums: List<Int>) = listOfNums.filter { num -> num % 2 == 0 }