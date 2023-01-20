/*

Write a program that reads non-negative floating point numbers or integers from the console until the user
enters a line that contains the word “quit”. Any other input than non-negative floating point number or integer
is silently ignored. If the user entered valid input, the program prints out the current average of numbers so far.
After user quits the program should print out the smallest number, largest number, the count of numbers and the
average of the numbers. If, for example, it is not possible to compute the average, the program should print "N/A"
in place of the number.

Use readLine() to read a line of input (completed with Enter) as a String. Note that readLine() returns an
optional value.

A nice way to implement reading loop is to use do - while. Do not store the numbers in a collection, it is
enough to maintain average, count, min and max. Assign appropriate initial values to these variables. (What
is sum before the user has any input? Perhaps null - so, use optionals).

Write your implementation into Kotlin main function ( fun main() { ... } ). Attach some sample executions
into comments box in your solution (in a way similar to what is shown below).

Hints:
- In Kotlin, you can use toDoubleOrNull() to convert a String to a Double. If the user enters "",
toDoubleOrNull returns null.
- Use the ? and ?: operators to handle the null case.
- If you have read 3 numbers and their average is 6.0, then the sum of numbers is 6.0 * 3 = 18.0
- Develop the program in steps! For example, write first a loop that reads user input until the end condition
becomes true
- You may find it useful to use Kotlin worksheet feature to try out parts of the program

Some sample runs:

Statistics computer starting...
Yes? huuhaa
Yes? -666
Yes? quit
Thank you. You gave 0 numbers.
Their min is N/A
Their max is N/A
Their average is N/A


Statistics computer starting...
Yes? 1.0
average is now 1.0
Yes? 2.0
average is now 1.5
Yes? 3.0
average is now 2.0
Yes? 4.000
average is now 2.5
Yes? quit
Thank you. You gave 4 numbers.
Their min is 1.0
Their max is 4.0
Their average is 2.5

Statistics computer starting...
Yes? 1
average is now 1.0
Yes? 2.0
average is now 1.5
Yes? -5
Yes? huuhaa
Yes? quit
Thank you. You gave 2 numbers.
Their min is 1.0
Their max is 2.0
Their average is 1.5

*/

// Implement your solution in the main function. Fill in your name and student number below.

// Exercise 1


fun main() {
    var i = 0
    var min = 0.0
    var max = 0.0
    var avg = 0.0
    var sum = 0.0


    println("Statistics computer starting...")
    println("Give me numbers!")

    do {
        println("Yes?")
        val input  = readlnOrNull()
        var inputnum = input?.toDoubleOrNull()

        if (input != null) {
            if (input.lowercase().contains("quit")){
                break
            } else if (inputnum == null) {
                println("Give me only numbers...")
            }else {
                inputnum = input.toDouble()
                if (inputnum >= 0){
                    i++
                    if (min == 0.0 || inputnum < min){
                        min = inputnum
                    }
                    if(max == 0.0 || inputnum > max){
                        max = inputnum
                    }
                    sum = sum + inputnum
                    avg = sum / i
                    println("Average is now $avg")
                }
            }
        }
    }while (true)
    if (i == 0){
        println("Thank you, you gave $i numbers")
        println("Their min is N/A")
        println("Their max is N/A")
        println("Their average is N/A")
    }else {
        println("Thank you, you gave $i numbers")
        println("Their min is $min")
        println("Their max is $max")
        println("Their average is $avg")
    }
}
/*
Statistics computer starting...
Give me numbers!
Yes?
moi
Give me only numbers...
Yes?
123
Average is now 123.0
Yes?
3
Average is now 63.0
Yes?
4
Average is now 43.333333333333336
Yes?
quit123
Thank you, you gave 3 numbers
Their min is 3.0
Their max is 123.0
Their average is 43.333333333333336

Process finished with exit code 0
*/
