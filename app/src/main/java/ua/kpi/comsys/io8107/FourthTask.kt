package ua.kpi.comsys.io8107

fun fourthTask(src_map: Map<String, MutableMap<String, Int>>): Map<String, Float> {
    val map: MutableMap<String, Float> = hashMapOf()

    var groupName: String
    var sum = 0f


    for (group in src_map) {
        groupName = group.key
        for (student in group.value) {
            sum += student.value
        }

        map[groupName] = (sum / group.value.size)
        sum = 0f
    }
    return map
}