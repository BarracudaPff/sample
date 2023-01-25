//import kotlinx.coroutines.MainScope
//import react.create
//import react.dom.client.createRoot
//import react.dom.html.ReactHTML.div
//import react.dom.html.ReactHTML.span
//import views.MyComponent
//import views.InfoList
//import web.dom.document
//import web.window.window
//
//val scope = MainScope()
//
//fun main() {
//    window.onload = {
//        val container = document.getElementById("root")!!
//
//        createRoot(container).render(
//            div.create {
//                child(span.create {
//                    +"span text"
//                })
//                child(InfoList.create {
//                    infos = listOf(
//                        "a", "b", "c", "d", "e", "f"
//                    )
//                    children = MyComponent.create {
//                        name = "custom-name"
//                    }
//                })
//            }
//        )
//    }
//}
