package ua.kpi.comsys.io8107

//import kotlin.math.ceil
import kotlin.math.nextTowards


val studentsStr =
    "Дмитренко Олександр - ІП-84; Матвійчук Андрій - ІВ-83; Лесик Сергій - ІО-82; Ткаченко Ярослав - ІВ-83; Аверкова Анастасія  ІО-83; Соловйов Даніїл - ІО-83; Рахуба Вероніка - ІО-81; Кочерук Давид - ІВ-83; Лихацька Юлія- ІВ-82; Головенець Руслан - ІВ-83; Ющенко Андрій - ІО-82; Мінченко Володимир - ІП-83; Мартинюк Назар - ІО-82; Базова Лідія - ІВ-81; Снігурець Олег - ІВ-81; Роман Олександр - ІО-82; Дудка Максим - ІО-81; Кулініч Віталій - ІВ-81; Жуков Михайло - ІП-83; Грабко Михайло - ІВ-81; Іванов Володимир - ІО-81; Востриков Нікіта - ІО-82; Бондаренко Максим - ІВ-83; Скрипченко Володимир - ІВ-82; Кобук Назар - ІО-81; Дровнін Павло - ІВ-83; Тарасенко Юлія - ІО-82; Дрозд Світлана - ІВ-81; Фещенко Кирил - ІО-82; Крамар Віктор - ІО-83; Іванов Дмитро - ІВ-82"


enum class Day(val value: Int){
    MONDAY(0), TUESDAY(1), WEDNESDAY(2), THURSDAY(3),
    FRIDAY(4), SATURDAY(5), SUNDAY(6);

    fun getDuration(day: Day): Int{
        return this.value - day.value
    }
}

fun main() {

//    val map1 = firstTask(studentsStr)
////    val map2 = secondTask(map1)
////    val map3 = thirdTask(map2)
////    val map4 = fourthTask(map3)
////    val map5 = fifthTask(map3)
////    println(map1)
////    println(map2)
////    println(map3)
////    println(map4)
////    println(map5)



    val day: Day = Day.MONDAY
    val value = day.value
    print(day.getDuration(Day.SUNDAY))
    print(value)

}




