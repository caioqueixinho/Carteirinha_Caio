package com.rafaelcosta.carteirinhadigital2devest_b.core.designsystem.component

import androidx.compose.runtime.Composable

@Composable
fun NavigationButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(
            width = 2.dp,
            color = MaterialTheme.colorScheme.secondary
        )
    ) {
        Text(text = text)
    }
}