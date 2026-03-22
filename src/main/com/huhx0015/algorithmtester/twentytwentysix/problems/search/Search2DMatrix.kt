class Search2DMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var targetFound = false

        matrix.forEach { array ->
            val searchResult = binarySearch(array = array, target = target)
            if (searchResult) {
                targetFound = true
            }
        }
        return targetFound
    }

    fun binarySearch(array: IntArray, target: Int): Boolean {
        var leftPointer = 0
        var rightPointer = array.size - 1

        while (leftPointer <= rightPointer) {
            val midPointer = (leftPointer + rightPointer) / 2
            val midValue = array[midPointer]

            when {
                target > midValue -> {
                    leftPointer = midPointer + 1
                }
                target < midValue -> {
                    rightPointer = midPointer - 1
                }
                else -> {
                    return true
                }
            }
        }

        return false
    }
}
