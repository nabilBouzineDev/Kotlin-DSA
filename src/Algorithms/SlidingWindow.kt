/**
 *
 *  Variant questions to implement sliding window technique...
 *
 * */

// Fixed Size
class MaxSumSubArray {

    /**
     *
     * Find the max sub array of a fixed size k
     * input: [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]
     *
     * */
    fun findMaxSubArray(array: IntArray, k: Int): Int {

        var currentSum = 0
        var maxValue = 0

        for (i in array.indices) {

            currentSum += array[i]

            // when i reach the third element at the sub array
            if (i >= k - 1) {
                maxValue = maxOf(maxValue, currentSum) // record this maximum value
                currentSum -= array[i - (k - 1)] // move the nex sub array by removing first element
            }
        }

        return maxValue
    }
}

fun main() {

    val exampleOne = MaxSumSubArray()
    println(exampleOne.findMaxSubArray(intArrayOf(4, 2, 1, 7, 8, 1, 2, 8, 1, 0), 3))
}