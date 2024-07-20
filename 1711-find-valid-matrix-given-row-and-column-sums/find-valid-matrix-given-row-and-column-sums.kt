class Solution {
    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
        val results:MutableList<MutableList<Int>> = mutableListOf()
        val values:MutableList<Int> = mutableListOf()
        for(i in colSum){
            values.add(i)
        }
        for(i in 0 until rowSum.size){
            results.add(MutableList(colSum.size){0})
        }

        for(i in 0 until rowSum.size){
            for(j in 0 until colSum.size){
                if(rowSum[i] == results[i].sum()){
                    continue
                }else{
                    val need = rowSum[i] - results[i].sum()
                    if(need <= values[j]){
                        results[i][j] = need
                        values[j] = values[j] - need
                    }else{
                        results[i][j] = values[j]
                        values[j] = 0
                    }
                }
            }
        }
        val array: Array<IntArray> = results.map { it.toIntArray() }.toTypedArray()
        return array
    }
}