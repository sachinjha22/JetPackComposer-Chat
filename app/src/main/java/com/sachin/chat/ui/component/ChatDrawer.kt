package com.sachin.chat.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sachin.chat.R
import com.sachin.chat.ui.theme.ChatComposerTheme


@Composable
fun DrawerContent(
    onProfileClicked: (String) -> Unit,
    onChatClicked: (String) -> Unit
) {
    Column(modifier = Modifier.apply {
        fillMaxSize()
        background(MaterialTheme.colorScheme.background)
    }) {
        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
        DrawerHeader()
        Divider()
        DrawerItemHeader("Chats")
        ChatItem("Composer", true) { onChatClicked("composer") }
        ChatItem("De-Tyeeeeee", false) { onChatClicked("De-Tyeeeeee") }
        DrawerItemHeader("Recent Profile")
        ProfileItem("Sachin jha(you)",R.drawable.me){onProfileClicked("123")}
        ProfileItem("Aliya",R.drawable.ali){onProfileClicked("456")}
    }
}

@Composable
fun DrawerHeader() {
    Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = CenterVertically
    ) {
        ChatIcon(
            contentDescription = null,
            modifier = Modifier.padding(2.dp)
        )
        Text(
            text = "ChatVat",
            modifier = Modifier.padding(start = 5.dp),
            style = MaterialTheme.typography.titleMedium,
            fontFamily = FontFamily(Font(R.font.karla_bold)),
            fontSize = 20.sp
        )
    }
}

@Composable
private fun Divider(modifier: Modifier = Modifier) {
    androidx.compose.material3.Divider(
        modifier = modifier,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
    )
}


@Composable
private fun DrawerItemHeader(text: String) {
    Box(
        modifier = Modifier
            .padding(28.dp)
            .heightIn(min = 52.dp),
        contentAlignment = CenterStart
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun ChatItem(text: String, isSelected: Boolean, onChatClicked: () -> Unit) {
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 5.dp)
            .clip(CircleShape)
            .then(
                if (isSelected) {
                    Modifier.background(MaterialTheme.colorScheme.primary)
                } else {
                    Modifier.background(MaterialTheme.colorScheme.onSurface)
                }
            )
            .clickable(onClick = onChatClicked),
        verticalAlignment = CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_jetchat_back),
            contentDescription = null,
            tint = if (isSelected) {
                MaterialTheme.colorScheme.background
            } else {
                MaterialTheme.colorScheme.onSecondary
            },
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
        )
        Text(
            text = text,
            color = if (isSelected) {
                MaterialTheme.colorScheme.background
            } else {
                MaterialTheme.colorScheme.onSecondary
            },
            modifier = Modifier.padding(start = 12.dp),
            style = MaterialTheme.typography.bodyMedium
        )

    }
}

@Composable
private fun ProfileItem(text: String, @DrawableRes profilePic: Int?, onProfileClicked: () -> Unit) {
    Row(
        modifier = Modifier
            .height(56.dp)
            .padding(horizontal = 12.dp)
            .clip(CircleShape)
            .clickable(onClick = onProfileClicked),
        verticalAlignment = CenterVertically
    ) {
        val paddingModifier = Modifier
            .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
            .size(24.dp)

        if(profilePic != null){
            Image(
                painter = painterResource(id = profilePic),
                contentDescription = null,
                modifier = paddingModifier.then(Modifier.clip(CircleShape)),
                contentScale = ContentScale.FillBounds
            )
        }else{
            Spacer(modifier = paddingModifier)
        }

        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}


@Preview
@Composable
fun DrawableView() {
    ChatComposerTheme {
        Surface {
            Column {
                DrawerContent(onProfileClicked = {}, onChatClicked = {})
            }
        }
    }
}