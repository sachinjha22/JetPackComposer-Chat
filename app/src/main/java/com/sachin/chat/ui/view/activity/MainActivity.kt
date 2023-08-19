package com.sachin.chat.ui.view.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sachin.chat.ui.component.ChatAppBar
import com.sachin.chat.ui.theme.ChatComposerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                initView()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun initView(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter,
    ){
        ChatAppBar(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground),
            title = {
                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    // Channel name
                    Text(
                        text = "ChatVat",
                        style = MaterialTheme.typography.titleMedium
                    )
                    // Number of members
                    Text(
                        text = "company",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChatComposerTheme {
        initView()
    }
}