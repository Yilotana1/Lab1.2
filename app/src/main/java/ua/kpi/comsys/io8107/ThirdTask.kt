package ua.kpi.comsys.io8107


fun thirdTask(src_map: Map<String, MutableMap<String, MutableList<Int>>>): Map<String, MutableMap<String, Int>> {
    val map: MutableMap<String, MutableMap<String, Int>> = hashMapOf()
    var valueMap: MutableMap<String, Int>

    for (group in src_map) {
        valueMap = hashMapOf()
        for (student in group.value) {
            var sum = 0
            for (grade in student.value) {
                sum += grade
            }

            valueMap[student.key] = sum
        }
        map[group.key] = valueMap
    }
    return map
}

