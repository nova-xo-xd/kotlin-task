fun main (args: Array<String>) {

    println("data types:")
    dataTypes()
    println("_________________________")
    println("sum of even numbers:")
    val x = listOf(1,2,3,4,5,6)
    val total = sumOfEvenNumbers(x)
    println("sum of even numbers in (1,2,3,4,5,6) = $total")
    println("_________________________")
    println("Number Categorization:")
    val n = readln().toInt()
    categorize(n)
    println("_________________________")
    println("the first 10 numbers of the Fibonacci sequence:")
    fibonacci()
    println("_________________________")
    println("Higher-Order Function:")
    val l = listOf("a","b","c","d","e","f","g","h","i")
    val l2 = applyToStrings(l) { it.uppercase() }
    println(l2)
    println("_________________________")
    println("Lambda Expression for Filtering:")
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val evenNumbers = numbers.filter { it % 2 == 0 }
    println(evenNumbers)
    println("_________________________")
    println("String Length Map:")
    val fruits = listOf("apple", "banana", "kiwi")
    val sorted = mapStringLengths(fruits)
    println(sorted)
    println("_________________________")
    println("person class:")
    val first = Person("Nader", 20)
    first.displayDetails()
    println("_________________________")
    println("Inheritance Hierarchy:")
    println("car:")
    val car = Car(true,"tesla", "cyber truck")
    car.displayInfo()
    println("bike")
    val bike = Motorcycle(2,"bike", "mountain")
    bike.displayInfo()
    println("_________________________")
    println("Nullable String Length:")
    val input = readln()
    println(nullableStringLength(input))
    println("_________________________")
    println("String Extension Function (count vowels):")
    val str = "nader"
    println(str)
    println("vowels = ${str.countVowels()}")
    println("_________________________")
    println("Operator Overloading:")
    val num1 = ComplexNumber(1.0, 2.0)
    val num2 = ComplexNumber(3.0, 4.0)
    val result = num1 + num2
    println(result)
    println("_________________________")
}

fun dataTypes () {
    var int = 1
    var double = 10.0
    var string = "Hello World"
    var boolean = true

    println(int)
    println(double)
    println(string)
    println(boolean)

    println("\nNew values:")

    int = 2
    double = 3.0
    string = "this is a string"
    boolean = false

    println(int)
    println(double)
    println(string)
    println(boolean)
}

fun sumOfEvenNumbers(numbers: List<Int>): Int {
    var total = 0
    for (number in numbers) {
        if (number % 2 == 0) {
            total += number
        }
    }
    return total
}

fun categorize(int: Int) {
    if (int > 0)
        println("positive number")
    else if (int < 0)
        println("negative number")
    else
        println("zero")
}

fun fibonacci() {
    var x = 0
    var y = 1
    var z:Int
    print("0,")
    print("$y,")
        for (i in 0..7) {
            z = x + y
            x = y
            y = z
            print("$z,")
        }
    println()
}

fun applyToStrings(strings: List<String>, func: (String) -> String): List<String> {
    return strings.map {it.uppercase()}
}


fun mapStringLengths(strings: List<String>): Map<String, Int> {
    val stringsMap = mutableMapOf<String, Int>()
    for (string in strings)
        stringsMap[string] = string.length
    return stringsMap
}


class Person (private var name: String, private var age: Int){
        fun displayDetails() {
        println(name)
        println(age)
    }
}


open class Vehicle (val make: String, val model: String) {
    open fun displayInfo(){}
}
class Car(private val electric: Boolean, make: String, model: String) : Vehicle(make, model) {

    override fun displayInfo() {
        println("electric = $electric")
        println("make = $make")
        println("model = $model")
    }
}
class Motorcycle(private val wheels: Int, make: String, model: String) : Vehicle(make, model) {
    override fun displayInfo() {
        println("wheels = $wheels")
        println("make = $make")
        println("model = $model")
    }
}


fun nullableStringLength(input: String?): Int {
    return input?.length ?: 0
}

fun String.countVowels(): Int {
    var count = 0
    val vowels = arrayListOf('a','e','i','o','u')
    for (l in this) {
        for (v in vowels) {
           if (v == l)
               count++
        }
    }
    return count
}

class ComplexNumber(private val real: Double, private val imaginary: Double) {
    operator fun plus(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(real + other.real, imaginary + other.imaginary)
    }
    override fun toString(): String {
        return "$real + ${imaginary}i"
    }
}