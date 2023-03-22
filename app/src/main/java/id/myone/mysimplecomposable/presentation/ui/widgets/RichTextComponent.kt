/**
 * Created by Mahmud on 21/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.widgets

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme

@Composable
fun RichTextComponent(
    modifier: Modifier = Modifier,
    text: AnnotatedString,
    tag: String,
    onClick: () -> Unit,
) {
    ClickableText(
        text = text,
        modifier = modifier,
        onClick = { offset ->
            text.getStringAnnotations(
                tag = tag, start = offset, end = offset
            ).firstOrNull()?.let { onClick() }
        },
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFF)
@Composable
private fun ShowRichTextComponent() {
    MySimpleComposableTheme {
        RichTextComponent(
            text =  buildAnnotatedString {
                append("Don't have an account")
                withStyle(
                    SpanStyle(color = Color(0xffBC8363))
                ) {
                    append(" " + "create an account now")
                }
            },
            tag = "create an account now",
            onClick = {}
        )
    }
}