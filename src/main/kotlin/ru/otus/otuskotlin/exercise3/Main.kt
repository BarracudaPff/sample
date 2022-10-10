// Пример комментария

/*
    Многострочный
    комментарий
    /* вместе со вложенным */
    здесь!
 */

/**
 * Здесь комментарий используется как строка документации
 */
fun main(args: Array<String>) {
    print(1234) // Простой вывод на консоль
    println(1234) // Простой вывод на консоль и в конце переход на новую строчку

    // <var/val> <name> = <value>    - Стандартное создание переменных
    // var <name>: <type>            - Можно не задавать значение, но только у `var`
    // <name> = 123                  -      но нужно указать тип

    val aSimple = 1
    var bSimple = -1

    var nonInit: Int
    nonInit = 444

    val correctNamingForLongVariable = 123123 // use camelCase!
    val not_correct_naming_for_long_variable = 123123 // use camelCase, not snake_case!

    val a = 1
    val b = 1; // не обязательно, но можно использовать

    val constant = 123 // константное value, значение изменить нельзя
    var variable = 123 // variable, которое может менять значение
    variable = -123

    val number: Int = 1 // явное указание типа - не обязательно
    val numberAuto = 1 // Kotlin автоматически поставит тип (здесь это будеет Int)

    val simpleString = "Строки пишутся через двойные кавычки"
    val simpleMultilineString = """
        Несколько
        строк
    """.trimIndent()
}
