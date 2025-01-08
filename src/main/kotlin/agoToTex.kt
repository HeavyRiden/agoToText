fun main() {
    print("Введите число секунд: ")
    val time = readln().toInt()
    println("Пользователь " + agoToText(time))
}

fun wordEndingMinute(timeAgo: Int): String { // Возвращает окончание для минут
    return when (timeAgo / 60) {
        1, 21, 31, 41, 51 -> "уту"
        2, 22, 32, 42, 52,
        3, 23, 33, 43, 53,
        4, 24, 34, 44, 54 -> "уты"

        else -> "ут"
    }
}

fun wordEndingHour(timeAgo: Int): String { // Возвращает окончание для часов
    return when (timeAgo / 3600) {
        1, 21 -> ""
        2, 3, 4, 22, 23, 24 -> "а"
        else -> "ов"
    }
}

fun agoToText(timeAgo: Int): String { // функция возвращает время, когда пользователь был последний раз онлайн

    return when (timeAgo) { // возвращает строку с учетом паджа
        in 0..60 -> "был(а) только что"
        in 61..3_600 -> "был(а) ${timeAgo / 60} мин${wordEndingMinute(timeAgo)} назад"
        in 3_601..86_400 -> "был(а) ${timeAgo / 3600} час${wordEndingHour(timeAgo)} назад"
        in 86_401..172_800 -> "был(а) вчера"
        in 172_801..345_600 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}