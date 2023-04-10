package com.example.androidbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasics.ui.theme.AndroidBasicsTheme

class BusinessCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardFull()
                }
            }
        }
    }
}

@Composable
fun BusinessCardFull() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF588b8b)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TopHalfOfCard(modifier = Modifier.weight(3F))
        BottomHalfOfCard(modifier = Modifier.weight(2F))
    }
}

@Composable
fun TopHalfOfCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
        )
        Text(
            text = "Marion Emmanuel Buhat",
            fontSize = 30.sp,
            color = Color(0xFFFFFFFF),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Beginner Android Developer",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3DDC84),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun BottomHalfOfCard(modifier: Modifier = Modifier) {
    val phone = painterResource(R.drawable.baseline_phone_24)
    val share = painterResource(R.drawable.baseline_share_24)
    val email = painterResource(R.drawable.baseline_email_24)
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        CardRow(
            content = "+639123456789",
            image = phone
        )
        CardRow(
            content = "@N/A",
            image = share
        )
        CardRow(
            content = "johndoe@gmail.com",
            image = email
        )
    }
}

@Composable
fun CardRow(content: String, image: Painter) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(
                top = 7.dp,
                bottom = 7.dp,
                start = 100.dp
            )
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
        )
        Text(
            text = content,
            color = Color(0xFFFFFFFF),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    start = 10.dp,
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardFull()
}