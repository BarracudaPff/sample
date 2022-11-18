package ru.otus.otuskotlin.m3l6

enum class Language {
    English,
    Italian,
    French,
}

interface Translation {
    fun translate(text: String, lang: Language)
}

class EnglishTranslation : Translation {
    override fun translate(text: String, lang: Language) {
        println("Translation for $text from $lang to English")
    }
}

class ItalianTranslation : Translation {
    override fun translate(text: String, lang: Language) {
        println("Translation for $text from $lang to Italian")
    }
}

class FrenchTranslation : Translation {
    override fun translate(text: String, lang: Language) {
        println("Translation for $text from $lang to French")
    }
}

class Translator {
    private val englishTranslation = EnglishTranslation()
    private val italianTranslation = ItalianTranslation()
    private val frenchTranslation = FrenchTranslation()

    fun translate(text: String, fromLang: Language, toLang: Language) {
        return when (toLang) {
            Language.English -> englishTranslation.translate(text, fromLang)
            Language.Italian -> italianTranslation.translate(text, fromLang)
            Language.French -> frenchTranslation.translate(text, fromLang)
        }
    }
}

fun main() {
    val translator = Translator()

    translator.translate("Sample text", Language.English, Language.Italian)
    translator.translate("Sample text", Language.French, Language.French)
    translator.translate("Sample text", Language.French, Language.English)
}
