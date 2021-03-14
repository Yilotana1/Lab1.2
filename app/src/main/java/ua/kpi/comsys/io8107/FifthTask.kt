package ua.kpi.comsys.io8107

fun fifthTask(src_map: Map<String, MutableMap<String, Int>>): Map<String, MutableList<String>>{
    val map: Map<String, MutableList<String>> = hashMapOf(
        "ІВ-81" to ArrayList(),
        "ІВ-82" to ArrayList(),
        "ІВ-83" to ArrayList(),
        "ІО-81" to ArrayList(),
        "ІО-82" to ArrayList(),
        "ІО-83" to ArrayList(),
        "ІП-83" to ArrayList(),
        "ІП-84" to ArrayList()
    )

    var groupName: String
    var points: Int
    for (group_item in src_map) {
        groupName = group_item.key
        for (student in group_item.value){
            points = student.value
            if (points >= 60){
                map[groupName]?.add(student.key)
            }
        }

    }
    return map
}