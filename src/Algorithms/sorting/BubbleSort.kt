package sorting

class BubbleSort {
    fun sorting(numbers: IntArray): IntArray {
        do {
            var swapped = false
            for (i in 0..<numbers.size - 1) {
                if (numbers[i] > numbers[i + 1]) {
                    val temp = numbers[i]
                    numbers[i] = numbers[i + 1]
                    numbers[i + 1] = temp
                    swapped = true
                }
            }
        } while (swapped)
        return numbers
    }
}

fun main() {
    val bubbleSort = BubbleSort()
    println(bubbleSort.sorting(intArrayOf(5, 1, 4, 2, 8)).joinToString(" "))
}