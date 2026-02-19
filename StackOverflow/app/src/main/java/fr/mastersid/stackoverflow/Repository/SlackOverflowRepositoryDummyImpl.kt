package fr.mastersid.stackoverflow.Repository

import fr.mastersid.stackoverflow.data.Question
import fr.mastersid.stackoverflow.data.QuestionsResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

class SlackOverflowRepositoryDummyImpl @Inject constructor(): SlackOverflowRepository {

    override val questionsResponse = MutableSharedFlow<QuestionsResponse>() //flow à chaud hotflow

    override suspend fun updateQuestionsInfo() {
        questionsResponse.emit(QuestionsResponse.Pending) //emet sur le flux une reponse en cours
        delay(5000)
        questionsResponse.emit(
            QuestionsResponse.Succes(
                listOf(
                    Question(
                        0,
                        "Find node that is connected to a node",
                        (0..20).random(),
                        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
                    ),
                    Question(
                        1,
                        "pdfjsLib not initializing and is undefined",
                        (0..20).random(),
                        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
                    ),
                    Question(
                        2,
                        "Error while building bundle in maven",
                        (0..20).random(),
                        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
                    ),
                    Question(
                        3,
                        "Translation of Bangladesh currency to words",
                        (0..20).random(),
                        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
                    ),
                    Question(
                        4,
                        "How to get update history of application installed on the Android platform",
                        (0..20).random(),
                        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
                    ),
                    Question(
                        5,
                        "Why does a floating-point multiplication compile more efficiently when I put it in an inline function?",
                        (0..20).random(),
                        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
                    ),
                    Question(
                        6,
                        "Get a single data entry from a custom database table in WordPress?",
                        (0..20).random(),
                        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
                    ),
                    Question(
                        7,
                        "Dynamic Array searchable Data Validation",
                        (0..20).random(),
                        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
                    ),
                    Question(
                        8,
                        "ReferenceError: HTMLElement is not defined in TypeScript",
                        (0..20).random(),
                        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
                    ),
                    Question(
                        9,
                        "Passing record id into a Bootstrap modal so modal file download button works",
                        (0..20).random(),
                        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
                    ),
                    Question(
                        10,
                        "How to make a structuredClone of a Proxy object?",
                        (0..20).random(),
                        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
                    ),
                    Question(
                        11,
                        "GCC warning: how to ignore -Wswitch-default on enum",
                        (0..20).random(),
                        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
                    ),
                    Question(
                        12,
                        "Create structured clone of Proxy",
                        (0..20).random(),
                        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
                    )
                )
            )
        )
    }
}