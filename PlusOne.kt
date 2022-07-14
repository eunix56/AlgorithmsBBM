object PlusOne {

    @JvmStatic
    fun main(args: Array<String>) {
        println(addOne(intArrayOf(9, 9, 9)).contentToString())
    }

    fun addOne(digits: IntArray): IntArray {
        val digitString = digits.joinToString { e -> "$e" }
        val digitInt = digitString.replace(", ", "").toInt() + 1
        return digitInt.toString().map {
            it.digitToInt()
        }.toIntArray()
    }
}