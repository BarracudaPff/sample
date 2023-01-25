package views

import react.*
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.span
import web.html.InputType

class IndexView : Component<Props, State>() {
    override fun render(): ReactNode {
        return span.create {
            +"Sample text"
        }
    }
}

external interface MyProps : Props {
    var name: String
}

val MyComponent = FC<MyProps> {
    var name by useState(it.name)

    div {
        +"Hello $name!"
    }

    input {
        type = InputType.text
        value = name
        onChange = { e ->
            name = e.target.value
        }
    }
}

external interface VideoListProps : PropsWithChildren {
    var infos: List<String>
}

val InfoList = FC<VideoListProps> { props ->

    for (video in props.infos) {
        p {
            key = video
            +video
        }
        child(props.children)
    }
}
