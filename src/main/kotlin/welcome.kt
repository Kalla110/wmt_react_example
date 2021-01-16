import components.Counter
import kotlinx.css.*
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import react.*
import styled.css
import styled.styledButton
import styled.styledDiv
import styled.styledInput

external interface WelcomeProps : RProps {
    var name: String
}

data class WelcomeState(val name: String) : RState

@JsExport
class Welcome(props: WelcomeProps) : RComponent<WelcomeProps, WelcomeState>(props) {

    init {
        state = WelcomeState(props.name)
    }



    override fun RBuilder.render() {
        styledDiv {
            css {
                +WelcomeStyles.textContainer
            }
            +"Hello, ${state.name}"
        }
        styledInput {
            css {
                +WelcomeStyles.textInput
                backgroundColor = Color.gray
            }
            attrs {
                type = InputType.text
                value = state.name
                onChangeFunction = { event ->
                    setState(
                            WelcomeState(name = (event.target as HTMLInputElement).value)
                    )
                }
            }
        }
        styledButton {
            css {
                padding = "3px 10px"
                borderRadius = LinearDimension("10px")
            }
            attrs {
                text("CLick Me!")
                onClickFunction = {
                    println("Clicked! ${state.name}")
                }
            }
        }
        child(Counter){
            attrs {
                start = 0
                max = 10
            }
        }
    }
}
