fun main() {
    print("Введите число секунд: ")
    val time = readln().toInt()
    println("Пользователь " + agoToText(time))
}

fun agoToText(timeAgo: Int): String { // функция возвращает время, когда пользователь был последний раз онлайн

    var wordEndingMinute = "ут"  // окончание для минут
    var wordEndingHour = "ов"  // окончание для часов

    if (timeAgo in 62..3_600) { // окончание для минут с учетом подежа
        when (timeAgo / 60) {
            1, 21, 31, 41, 51 -> wordEndingMinute = "уту"
            2, 22, 32, 42, 52,
            3, 23, 33, 43, 53,
            4, 24, 34, 44, 54 -> wordEndingMinute = "уты"
        }
    } else if (timeAgo in 3602..86_400) { // окончание для часов с учетом падежа
        when (timeAgo / 3600) {
            1, 21 -> wordEndingHour = ""
            2, 3, 4, 22, 23, 24 -> wordEndingHour = "а"
        }
    }

    return when (timeAgo) { // возвращает строку с учетом паджа
        in 0..60 -> "был(а) только что"
        in 61..3_600 -> "был(а) ${timeAgo / 60} мин$wordEndingMinute назад"
        in 3_601..86_400 -> "был(а) ${timeAgo / 3600} час$wordEndingHour назад"
        in 86_401..172_800 -> "был(а) вчера"
        in 172_801..345_600 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}