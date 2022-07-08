import java.util.*

object ThirdDistinctMaximum {

    //Accepted
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(1,-2147483648,2)

        println(thirdMaxSorted(arr))
    }

    fun thirdMax(nums: IntArray): Int {
        var max = Long.MIN_VALUE
        var secondMax = Long.MIN_VALUE
        var thirdMax: Long = Long.MIN_VALUE
        var count = 0

        for (i in nums.indices) {
            if (nums[i] > max) {
                if (secondMax > thirdMax) {
                    thirdMax = secondMax
                    count++
                }

                if (max > secondMax)
                    secondMax = max
                max = nums[i].toLong()
            }

            if (nums[i] in (secondMax + 1) until max) {
                if (secondMax > (thirdMax)) {
                    thirdMax = secondMax
                    count++
                }
                secondMax = nums[i].toLong()
            }

            if (nums[i] in (thirdMax) until secondMax) {
                thirdMax = nums[i].toLong()
                count++
            }

//            if (nums[i] == Int.MIN_VALUE && thirdMax == nums[i] && secondMax >= thirdMax) {
//                count++
//            }
            //The issue is (Integer.MIN_VALUE, 1, 1) and (Integer.MIN_VALUE, 1, 2)

        }

        return if (count > 0) thirdMax.toInt()
        else max.toInt()
    }

   // Sorted solution
    fun thirdMaxSorted(nums: IntArray): Int {
       var count = 0
       Arrays.sort(nums)
       nums.toMutableList().reverse()

       for (i in nums.indices) {
           if (i == 0)
               count++
           else if (nums[i] != nums[i - 1])
               count++
           else if (count == 3)
               return nums[i]
       }
       return nums[0]
    }

}