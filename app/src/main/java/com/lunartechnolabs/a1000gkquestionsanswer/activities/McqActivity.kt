package com.lunartechnolabs.a1000gkquestionsanswer.activities

import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.lunartechnolabs.a1000gkquestionsanswer.ui.theme.GKQuestionsAnswerTheme


class McqActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GKQuestionsAnswerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyContent()
                    AdvertView3()

                }
            }
        }
    }
}


@Composable
fun AdvertView3(modifier: Modifier = Modifier) {
    val isInEditMode = LocalInspectionMode.current
    if (isInEditMode) {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .background(androidx.compose.ui.graphics.Color.Red)
                .padding(horizontal = 2.dp, vertical = 6.dp),
            textAlign = TextAlign.Center,
            color = androidx.compose.ui.graphics.Color.White,
            text = "Advert Here",
        )
    } else {
        AndroidView(
            modifier = modifier.fillMaxWidth(),
            factory = { context ->
                AdView(context).apply {
                    setAdSize(AdSize.BANNER)
                    adUnitId = "ca-app-pub-1844978836909273/5553500693"
                    loadAd(AdRequest.Builder().build())
                }
            }
        )
    }
}


@Composable
fun MyContent(){

    // Declare a string that contains a url
    val mUrl = "https://interviewassit.000webhostapp.com/mcq.html"

    // Adding a WebView inside AndroidView
    // with layout as full screen
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            val webSettings: WebSettings = this.settings
            webSettings.javaScriptEnabled = true
            webSettings.domStorageEnabled = true

            webViewClient = WebViewClient()
            loadUrl(mUrl)
        }
    }, update = {
        it.loadUrl(mUrl)
    })
}

