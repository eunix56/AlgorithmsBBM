object StringParenthesis {

    @JvmStatic
    fun main(args: Array<String>) {
        val string = "()[]{]"

        println(matchValidBracket(string))
    }

    //O(n) - Time complexity
    //O(log n) - Space complexity
    fun matchValidBracket(bracketString: String): Boolean {
        val hashMap = mapOf(Pair(')', '('), Pair(']', '['), Pair('}', '{'))
        val array = CharArray(bracketString.length)
        var count = 0
        var valid = false

        for (i in bracketString) {
            if (i in hashMap.values) {
                count++
                array[count - 1] = i
            }
            if (i in hashMap.keys) {
                if (array.isEmpty()) return false

                valid = array[count - 1] == hashMap[i]
            }
        }

        return valid
    }
}