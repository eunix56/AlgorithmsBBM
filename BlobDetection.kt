
object BlobDetection {

    @JvmStatic
    fun main(args: Array<String>) {
        //[0, 1, 1, 0, 0]
        //[0, 0, 1, 0, 1]
        //[1, 0, 1, 0, 1]
        //[0, 0, 0, 0, 1]
        val array: Array<IntArray> = arrayOf(
            intArrayOf(0, 1, 1, 0, 0), intArrayOf(0, 0, 1, 0, 1),
            intArrayOf(1, 0, 1, 0, 1), intArrayOf(0, 0, 0, 0, 1)
        )

        val arr: Array<String> = arrayOf(
            "0, 1, 1, 0, 0", "0, 0, 1, 0, 1",
            "1, 0, 1, 0, 1", "0, 0, 0, 0, 1"
        )

        for (row in arr)
            println(row)

        println(nearestNeighbours(arr, 2, 2))
    }

    fun nearestNeighbours(arr: Array<String>, row: Int, column: Int): Array<Char> {
        if (isValidRow(arr, row - 1) &&
            isValidRow(arr, row + 1)  &&
            isValidColumn(arr, row, column - 1) &&
            isValidColumn(arr, row, column + 1)
        )
            return arrayOf(arr[row - 1][column], arr[row + 1][column],
            arr[row][column - 1], arr[row][column + 1])

        return arrayOf(arr[row][column])
    }

    fun isValidRow(arr: Array<String>, row: Int): Boolean {
        var valid = true
        if (row < 0 || row >= arr.size)
            valid = false

        return valid
    }

    fun isValidColumn(arr: Array<String>, row: Int, column: Int): Boolean {
        var valid = true
        if (column < 0 || column >= arr[row].length)
            valid = false

        return valid
    }
}