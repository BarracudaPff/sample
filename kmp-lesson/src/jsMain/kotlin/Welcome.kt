import csstype.px
import csstype.rgb
import react.FC
import react.Props
import emotion.react.css
import kotlinx.browser.window
import org.w3c.fetch.RequestInit
import react.dom.html.InputType
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.useState

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.fetch.Headers

external interface WelcomeProps : Props {
    var name: String
}

val Welcome = FC<WelcomeProps> { _ ->
    var a by useState(0.0)
    var b by useState(0.0)
    var c by useState(0.0)

    fun updateEq(a: Double, b: Double) {
        window
            .fetch("/calc/sum", RequestInit(
                method = "POST",
                body = Json.encodeToString(CalcData(a, b)),
                headers = Headers().also {
                    it.set("Accept", "application/json")
                    it.set("Content-Type", "application/json")
                }
            ))
            .then { it.text() }
            .then { c = Json.decodeFromString<CalcResult>(it).c }
    }


    div {
        css {
            padding = 5.px
            backgroundColor = rgb(8, 97, 22)
            color = rgb(56, 246, 137)
        }
        +"$a + $b = $c"
    }
    input {
        css {
            marginTop = 5.px
            marginBottom = 5.px
            fontSize = 14.px
        }
        type = InputType.text
        value = a.toString()
        onChange = { event ->
            a = event.target.value.toDouble()
            updateEq(event.target.value.toDouble(), b)
        }
    }
    input {
        css {
            marginTop = 5.px
            marginBottom = 5.px
            fontSize = 14.px
        }
        type = InputType.text
        value = b.toString()
        onChange = { event ->
            b = event.target.value.toDouble()
            updateEq(a, event.target.value.toDouble())
        }
    }
}