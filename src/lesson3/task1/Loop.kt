@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr
import java.lang.Math.*
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var n1 = abs(n)
    var k = 0
    if (n1 == 0)
        return 1
    else {
        while (n1 > 0) {
            n1 /= 10
            k++
        }
        return k
    }
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var f = 1
    var s = 1
    var o = 0
    if (n == 1 || n == 2)
        return 1
    else {
        for (m in 3..n) {
            o = f + s
            f = s
            s = o
        }
    }
    return o
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */

fun lcm(m: Int, n: Int): Int {
    val mi: Int = m.coerceAtMost(n)
    var nod = 1
    if (m == n)
        return m
    for (i in mi downTo 2)
        if (m % i == 0 && n % i == 0) {
            nod = i
            break
        }
    return m * n / nod
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var a = 3
    if (n % 2 == 0)
        return 2
    else
        for (i in 1..n / 2) {
            if (n % a == 0) {
                return a
            }
            a += 2
        }
    return 0
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int = n / minDivisor(n)

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    val mi: Int = m.coerceAtMost(n)
    for (i in 2..mi)
        if (m % i == 0 && n % i == 0)
            return false
    return true
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {

    if ((sqrt(n.toDouble()).toInt() - sqrt(m.toDouble()).toInt() >= 1.0) ||
        floor(sqrt(m.toDouble())) == sqrt(m.toDouble()) ||
        ceil(sqrt(n.toDouble())) == sqrt(n.toDouble())
    )
        return true

    return false
}

/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var x1 = x
    var o = 0
    while (x1 != 1) {
        o++
        if (x1 % 2 == 0)
            x1 /= 2
        else
            x1 = 3 * x1 + 1
    }
    return o
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double {
    var x1 = x % (2 * PI)
    var h = 3
    var ch = 1
    var sin = x1
    while (abs(x1.pow(h) / factorial(h)) >= abs(eps)) {
        if (ch % 2 != 0) {
            sin -= x1.pow(h) / factorial(h)
        } else {
            sin += x1.pow(h) / factorial(h)
        }
        ch++
        h += 2
    }
    return sin
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double {
    var x1 = x % (2 * PI)
    var h = 2
    var ch = 1
    var cos = 1.0
    while (abs(x1.pow(h) / factorial(h)) >= abs(eps)) {
        if (ch % 2 != 0) {
            cos -= x1.pow(h) / factorial(h)
        } else {
            cos += x1.pow(h) / factorial(h)
        }
        ch++
        h += 2
    }
    return cos
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var n1 = n
    var dl = 1
    var o = 0
    dl = digitNumber(n1)
    n1 = n
    for (i in dl - 1 downTo 0) {
        o += ((n1 % 10) * pow(10.0, i.toDouble())).toInt()
        n1 /= 10
    }
    return o
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean = TODO()

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean = TODO()

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var valueNum = 1
    var num = 1
    var last = 1
    while (valueNum < n) {
        num++
        var sNum = sqr(num)
        var ch = 0
        last = sNum
        ch = digitNumber(sNum)
        valueNum += ch
    }
    val r = valueNum - n
    val o = (last / pow(10.0, r.toDouble())).toInt() % 10
    return o
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var valueNum = 1
    var num = 1
    var last = 1
    var r: Int
    var o: Int
    while (valueNum < n) {
        num++
        var s_num = fib(num)
        var ch = 0
        last = s_num
        while (s_num > 0) {
            ch++
            s_num /= 10
        }
        valueNum += ch
    }
    r = valueNum - n
    o = (last / pow(10.0, r.toDouble())).toInt() % 10
    return o
}
