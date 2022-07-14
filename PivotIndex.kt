object PivotIndex {
    @JvmStatic
    fun main(args: Array<String>) {
        println(getPivotIndex(intArrayOf(-1,-1,-1,1,1,1))) //[3, -2, -3, 2, 2], [-1,-1,-1,-1,0,1], [-1,-1,-1,1,1,1]
    }

    fun pivotIndex(nums: IntArray): Int {
        val left = 0
        val right = nums.size - 1


        return traverseArray(left, right, nums)
    }

    /*
    A right pointer and a left pointer. I add values from the right as I add from the left.
    Once they are equal, I return the value just in between. If one is greater than the other, then I return the index to the former value
    If they are not equal, and one addition gives zero just next to the last index or first index, I return that index.

    P.S.: This only works for positive integer arrays. When there is a negative value,
    it fails.
     */
    fun traverseArray(left: Int, right: Int, nums: IntArray): Int {
        val pointer = 0
        val secondPointer = nums.size - 1

        if (left >= right) return -1

        val mid = (left + right)/2

        return if (addNumbers(pointer, mid-1, nums) ==
            addNumbers(mid + 1, secondPointer, nums))
            mid
        else if (addNumbers(pointer, mid-1, nums) >
            addNumbers(mid + 1, secondPointer, nums))
            traverseArray(left, right - 1, nums)
        else if (addNumbers(pointer, mid-1, nums) <
            addNumbers(mid + 1, secondPointer, nums))
            traverseArray(left + 1, right, nums)
        else - 1
    }

    fun addNumbers(left: Int, right: Int, nums: IntArray): Int {
        var count = 0
        for (i in left..right) {
            count += nums[i]
        }
        return count
    }

    //solution
    fun getPivotIndex(nums: IntArray): Int {
        val pivotSum = IntArray(nums.size)
        var leftSum: Int
        var rightSum: Int
        var count = 0

        for(i in nums.indices) {
            count += nums[i]
            pivotSum[i] = count
        }

        for(i in pivotSum.indices) {
            leftSum = pivotSum[i] - nums[i]
            rightSum = pivotSum[pivotSum.size - 1] - pivotSum[i]

            if (leftSum == rightSum){
                return i
            }
        }
        return -1
    }


}