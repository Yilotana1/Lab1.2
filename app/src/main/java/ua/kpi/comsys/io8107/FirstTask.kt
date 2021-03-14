package ua.kpi.comsys.io8107

import java.lang.Exception

fun firstTask(src: String): Map<String, MutableList<String>> {
    val list: List<String> = split(src)
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

    for (s in list) {
        val item = parseString(s)
        val name = item[0]
        val key = item[1]
        map[key]?.add(name)
    }

    val comparator = UkrComparator()
    for (i in map) {
        i.value.sortWith(comparator)
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

class UkrComparator : Comparator<String> {
    val alph: Map<Char, Int> = sortedMapOf(
        'А' to 0, 'Б' to 1, 'В' to 2,
        'Г' to 3, 'Д' to 4, 'Е' to 5,
        'Є' to 6, 'Ж' to 7, 'З' to 8,
        'И' to 9, 'І' to 10, 'Ї' to 11,
        'Й' to 12, 'К' to 13, 'Л' to 14,
        'М' to 15, 'Н' to 16, 'О' to 17,
        'П' to 18, 'Р' to 19, 'С' to 20,
        'Т' to 21, 'У' to 22, 'Ф' to 23,
        'Х' to 24, 'Ц' to 25, 'Ч' to 26,
        'Ш' to 27, 'Щ' to 28, 'Ь' to 29,
        'Ю' to 30, 'Я' to 31,

        'а' to 32, 'б' to 33, 'в' to 34,
        'г' to 35, 'д' to 36, 'е' to 37,
        'є' to 38, 'ж' to 39, 'з' to 40,
        'и' to 41, 'і' to 42, 'ї' to 43,
        'й' to 44, 'к' to 45, 'л' to 46,
        'м' to 47, 'н' to 48, 'о' to 49,
        'п' to 50, 'р' to 51, 'с' to 52,
        'т' to 53, 'у' to 54, 'ф' to 55,
        'х' to 56, 'ц' to 57, 'ч' to 58,
        'ш' to 59, 'щ' to 60, 'ь' to 61,
        'ю' to 62, 'я' to 63
    )

    override fun compare(o1: String?, o2: String?): Int {
        val minLength: Int?
        minLength = if (o1?.length!! < o2?.length!!) {
            o1.length
        } else {
            o2.length
        }
        var c1: Char?
        var c2: Char?
        var i1: Int?
        var i2: Int?
        for (i in 0 until minLength) {
            c1 = o1[i]
            c2 = o2[i]
            i1 = alph[c1]
            i2 = alph[c2]
            if (i1!! > i2!!) {
                return 1
            } else if (i1 < i2) {
                return -1
            }
        }
        return 0
    }

}
