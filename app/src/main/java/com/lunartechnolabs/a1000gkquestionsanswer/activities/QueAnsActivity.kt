package com.lunartechnolabs.a1000gkquestionsanswer.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lunartechnolabs.a1000gkquestionsanswer.getJsonDataFromAsset
import com.lunartechnolabs.a1000gkquestionsanswer.model.Data
import com.lunartechnolabs.a1000gkquestionsanswer.ui.theme.GKQuestionsAnswerTheme
import java.lang.reflect.Type


class QueAnsActivity : ComponentActivity() {
    private lateinit var fact : ArrayList<Data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = intent.extras
        val filename = bundle?.getString("file_name")

        if (filename !=null){
            val jsonFileString = getJsonDataFromAsset(this, filename)

            val gson = Gson()
            val myType: Type = object : TypeToken<List<Data>>() {}.type

            fact = gson.fromJson(jsonFileString, myType)
        }

        setContent {
             GKQuestionsAnswerTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Greeting2(fact)
                    AdvertView2()
                }
            }
        }
    }
}


@Composable
fun AdvertView2(modifier: Modifier = Modifier) {
    val isInEditMode = LocalInspectionMode.current
    if (isInEditMode) {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.Red)
                .padding(horizontal = 2.dp, vertical = 6.dp),
            textAlign = TextAlign.Center,
            color = Color.White,
            text = "Advert Here",
        )
    } else {
        AndroidView(
            modifier = modifier.fillMaxWidth(),
            factory = { context ->
                AdView(context).apply {
                    setAdSize(AdSize.BANNER)
                    adUnitId = "ca-app-pub-1844978836909273/2883654069"
                    loadAd(AdRequest.Builder().build())
                }
            }
        )
    }
}

@Composable
fun Greeting2(fact: ArrayList<Data>) {
    LazyColumn() {
        itemsIndexed(fact) { index,messages ->
            val context = LocalContext.current
            Card(modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                , elevation = 7.dp){
                Column() {
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(text = "${index + 1} प्रश्न : " + messages.que , fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = " उत्तर : " +  messages.ans , fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
     GKQuestionsAnswerTheme {
         Card(modifier = Modifier
             .padding(5.dp)
             .fillMaxWidth()
             , elevation = 7.dp){
             Column() {
                 Spacer(modifier = Modifier.height(10.dp))
                 Text(text = "What colour is vermilion a shade of")
                 Spacer(modifier = Modifier.height(10.dp))
                 Text(text = "Red")
                 Spacer(modifier = Modifier.height(10.dp))
             }
         }
    }
}