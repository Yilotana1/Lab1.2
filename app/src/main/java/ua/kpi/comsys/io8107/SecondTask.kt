package ua.kpi.comsys.io8107

import java.text.Collator
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.ceil


fun randomValue(maxValue: Int): Int {
    return when ((1..6).random()) {
        1 -> ceil(maxValue.toFloat() * 0.7).toInt()
        2 -> ceil(maxValue.toFloat() * 0.9).toInt()
        3, 4, 5 -> maxValue
        else -> 0
    }
}


fun getRandomList(size: Int): MutableList<Int> {
    val list: ArrayList<Int> = ArrayList(size)
    for (i in 1..size) {
        list.add(randomValue(8))
    }
    return list
}


fun secondTask(src_map: Map<String, MutableList<String>>): Map<String, MutableMap<String, MutableList<Int>>> {
    val map: MutableMap<String, MutableMap<String, MutableList<Int>>> = hashMapOf()

    for (group in src_map) {
        var subMap: MutableMap<String, MutableList<Int>> = TreeMap(Collator.getInstance(Locale("uk", "UA")))
        for (student in group.value) {
            subMap[student] = getRandomList(10)
        }
        map[group.key] = subMap


    }
    return map
}