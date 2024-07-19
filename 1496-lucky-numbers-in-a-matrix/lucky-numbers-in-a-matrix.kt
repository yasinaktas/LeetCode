class Solution {
    fun luckyNumbers (matrix: Array<IntArray>): List<Int> {
        val results:MutableList<Int> = mutableListOf()
        for(i in 0 until matrix.size){
            val min = matrix[i].min()
            val minCol = matrix[i].indexOf(min)
            var isMax = true
            inner@for(j in 0 until matrix.size){
                if(j != i && matrix[j][minCol] > min){
                    isMax = false
                    break@inner
                }
            }
            //println("$min $minCol $isMax")
            if(isMax) results.add(min)
        }
        return results.toList()
    }
}