package components

import adapter.isSorted
import kotlinx.html.js.onClickFunction
import react.RProps
import react.functionalComponent
import react.useEffect
import react.useState
import styled.styledButton
import styled.styledH1

external interface CounterProps : RProps {
    var start: Int
    var max: Int
}

val Counter = functionalComponent<CounterProps> { props ->

    val (currentCount, setCurrentCount) = useState(props.start)

    useEffect(listOf(currentCount)) {
        if (currentCount > 5)
            console.log("greater than 5")
    }

    val arrayA = arrayOf(1,2,3)
    val arrayB = arrayOf(1,4,3)

    println("List a is sorted? ${isSorted((arrayA))}")
    println("List b is sorted? ${isSorted((arrayB))}")

    styledH1 {
        +"$currentCount"
    }

    styledButton {
        attrs {
            onClickFunction = {
                if (currentCount == props.max) setCurrentCount(props.start) else setCurrentCount(currentCount + 1)
            }
            +"Count until max!"
        }
    }
}