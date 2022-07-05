object InfiniteArray {

    @JvmStatic
    fun main(args: Array<String>) {
        //TEST INPUT 1: -3, -2, -1, " ", " ", " "
        // Value: -1

        //TEST INPUT 2: 0, 1, 3, 6, 7, 9, 13, 17, 19, 33, 51, " ", " "
        // Value: 17

        //TEST INPUT 3: " ", " ", " "
        // Value: 1

        //TEST INPUT 4: 1, 3, 5, 6, 7, 10, " ", " ", " "
        // Value: 2

        val arr: Array<Any> = arrayOf(1, 2, 3, 5, 6, 7, 10, " ", " ", " ")

        println(getValidValue(arr, 6))
        println(getValidVal(arr, 7))
    }

    //O(n) - Time complexity
    //O(1) - Space complexity
    fun getValidValue(arr: Array<Any>, value: Int): Int {
        val invalid = " "
        if (arr[0] == invalid)
            return -1

        for (i in arr.indices) {
            if (arr[i] == value)
                return i
        }

        return -1
    }

    fun getValidVal(arr: Array<Any>, value: Int): Int {
        val invalid = " "
        var count = 0
        if (arr[0] == invalid)
            return -1

        while (arr[count] != invalid) {
            if (arr[count] == value) return count
            ++count
        }

        return -1
    }
}