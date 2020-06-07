import java.util.*
import java.util.stream.Collectors

private var minsum = 0
var cubes: List<List<Int>> = ArrayList()

    fun main(args: Array<String>) {
            val num = readLine()?.toIntOrNull() ?: 0
            var k = 0
            minsumcubes(num)
            println("Number entered : $num\nThe minimum number of operations are $minsum\n")
            for (i in cubes.indices) {
                if (cubes[i].size == minsum) {
                    for (j in cubes[i].indices) {
                        if (j != cubes[i].size - 1) print(cubes[i][j].toString() + "^3 + ") else print(cubes[i][j].toString() + "^3\n")
                    }
                    k++
                }
            }
            if (minsum == 2 && k >= 2) println("\nThis is a Ramanujan Hardy Number")
    }

    private fun minsumcubes(num: Int) {
        val limit = Math.cbrt(num.toDouble()).toInt()
        var n = 0
        var min = num
        var temp = num
        var templimit = limit
        var i = limit
        var a = 0
        var cube: MutableList<Int> = ArrayList()
        var arr: MutableList<List<Int>> = ArrayList()
        while (i > 0) {
            temp -= Math.pow(templimit.toDouble(), 3.0).toInt()
            cube.add(n++, templimit)
            if (temp == 0) { 
                if (min >= n) {
                    min = n
                    Collections.sort(cube)
                    arr.add(a++, cube)
                }
                cube = ArrayList()
                temp = num
                templimit = --i
                n = 0
                continue
            }
            templimit = Math.cbrt(temp.toDouble()).toInt()
        }
                    
        cubes = arr.stream().distinct().collect(Collectors.toList())
        minsum = min
    }
