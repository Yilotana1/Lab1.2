package ua.kpi.comsys.io8107

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
        list.add(randomValue(10))
    }
    return list
}


fun secondTask(src_map: Map<String, MutableList<String>>): Map<String, MutableMap<String, MutableList<Int>>> {
    val map: Map<String, MutableMap<String, MutableList<Int>>> = hashMapOf(
        "ІВ-81" to HashMap(),
        "ІВ-82" to HashMap(),
        "ІВ-83" to HashMap(),
        "ІО-81" to HashMap(),
        "ІО-82" to HashMap(),
        "ІО-83" to HashMap(),
        "ІП-83" to HashMap(),
        "ІП-84" to HashMap()
    )
    var mapValue: MutableMap<String, MutableList<Int>>

    var groupName: String
    for (group_item in src_map) {
        groupName = group_item.key
        for (student in group_item.value) {
            mapValue = map[groupName]!!
            mapValue[student] = getRandomList(9)
        }
    }
    return map
}