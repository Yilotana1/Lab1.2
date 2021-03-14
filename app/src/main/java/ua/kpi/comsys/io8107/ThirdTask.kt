package ua.kpi.comsys.io8107


fun thirdTask(src_map: Map<String, MutableMap<String, MutableList<Int>>>): Map<String, MutableMap<String, Int>> {
    val map: Map<String, MutableMap<String, Int>> = hashMapOf(
        "ІВ-81" to HashMap<String, Int>(),
        "ІВ-82" to HashMap<String, Int>(),
        "ІВ-83" to HashMap<String, Int>(),
        "ІО-81" to HashMap<String, Int>(),
        "ІО-82" to HashMap<String, Int>(),
        "ІО-83" to HashMap<String, Int>(),
        "ІП-83" to HashMap<String, Int>(),
        "ІП-84" to HashMap<String, Int>()
    )

    var groupName: String
    var studentName: String
    var points: MutableList<Int>
    var sum = 0
    var itemMap: MutableMap<String, Int>

    for (group_item in src_map) {
        groupName = group_item.key

        for (student in group_item.value) {
            studentName = student.key
            points = student.value

            for (i in points) {
                sum += i
            }
            itemMap = map[groupName]!!
            itemMap[studentName] = sum
            sum = 0
        }
    }
    return map
}