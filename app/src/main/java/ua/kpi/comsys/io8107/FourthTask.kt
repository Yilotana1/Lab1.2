package ua.kpi.comsys.io8107

fun fourthTask(src_map: Map<String, MutableMap<String, Int>>): Map<String, Float>{
    val map: MutableMap<String, Float> = hashMapOf(
        "ІВ-81" to 0f,
        "ІВ-82" to 0f,
        "ІВ-83" to 0f,
        "ІО-81" to 0f,
        "ІО-82" to 0f,
        "ІО-83" to 0f,
        "ІП-83" to 0f,
        "ІП-84" to 0f
    )

    var groupName: String
    var sum = 0f

    for (group_item in src_map){
        groupName = group_item.key
        for (student in group_item.value){
            sum += student.value
        }
        map[groupName] = (sum/group_item.value.size)
        sum = 0f
    }
    return map
}