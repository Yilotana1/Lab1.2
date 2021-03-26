package ua.kpi.comsys.io8107

fun fifthTask(src_map: Map<String, MutableMap<String, Int>>): Map<String, MutableList<String>> {
    val map: MutableMap<String, MutableList<String>> = hashMapOf()

    var groupName: String
    var grades: Int
    for (group in src_map) {
        groupName = group.key
        for (student in group.value) {
            grades = student.value
            if (grades >= 60) {
                if (!map.containsKey(groupName)) {
                    val arr = ArrayList<String>()
                    arr.add(student.key)
                    map[groupName] = arr
                } else map[groupName]?.add(student.key)
            }
        }

    }
    return map
}