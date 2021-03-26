package ua.kpi.comsys.io8107

import java.lang.Exception
import java.text.Collator
import java.util.*
import kotlin.collections.ArrayList

fun firstTask(src: String): Map<String, MutableList<String>> {
    val list: List<String> = split(src)
    var map: MutableMap<String, MutableList<String>> = hashMapOf()

    for (s in list) {
        val item = parseString(s)
        val name = item[0]
        val key = item[1]

        if (!map.containsKey(key)) {
            val arr = ArrayList<String>()
            arr.add(name)
            map[key] = arr
        } else map[key]?.add(name)
    }

    for (i in map) {
        i.value.sortWith(Collator.getInstance(Locale("uk", "UA")))
    }

    return map
}


fun split(src: String): List<String> {
    return src.split("; ")

}

fun parseString(src: String): Array<String> {
    var status = 0
    var name = "unknown"
    var group = "unknown"

    for (i in src.indices) {
        if (src[i] == ' ' && status == 0) {
            status++
        } else if (src[i] == ' ' && status == 1) {
            name = src.substring(0, i)
            status += 1
        } else if (src[i] != ' ' && src[i] != '-' && status == 2) {
            group = src.substring(i, src.length)
            break
        }
    }

    if (name == "unknown" || group == "unknown") throw Exception("specified data isn't exhausted")

    return arrayOf(name, group)
}



