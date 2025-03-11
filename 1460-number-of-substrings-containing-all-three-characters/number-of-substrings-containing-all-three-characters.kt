class Solution {
    fun numberOfSubstrings(s: String): Int {
        val letters = listOf("a","b","c")
        var count = 0
        val length = s.length
        var j = 3
        for(i in 0 until length-2){
            while(j<length && !letters.all{s.substring(i,j).contains(it)}){
                j++
            }
            if(j<=length && letters.all{s.substring(i,j).contains(it)}){
                val subCount = length-j+1
                count += subCount
            }
        }
        return count
    }
}