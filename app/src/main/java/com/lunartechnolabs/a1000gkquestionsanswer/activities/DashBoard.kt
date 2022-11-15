package com.lunartechnolabs.a1000gkquestionsanswer.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.lunartechnolabs.a1000gkquestionsanswer.R
import com.lunartechnolabs.a1000gkquestionsanswer.model.FileData
import com.lunartechnolabs.a1000gkquestionsanswer.ui.theme.GKQuestionsAnswerTheme

class DashBoard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GKQuestionsAnswerTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                    AdvertView()

                }
            }
        }
    }
}
@Composable
fun AdvertView(modifier: Modifier = Modifier) {
    val isInEditMode = LocalInspectionMode.current
    if (isInEditMode) {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .background(Red)
                .padding(horizontal = 2.dp, vertical = 6.dp),
            textAlign = TextAlign.Center,
            color = White,
            text = "Advert Here",
        )
    } else {
        AndroidView(
            modifier = modifier.fillMaxWidth(),
            factory = { context ->
                AdView(context).apply {
                    setAdSize(AdSize.BANNER)
                        adUnitId = "ca-app-pub-1844978836909273/1456882207"
                    loadAd(AdRequest.Builder().build())
                }
            }
        )
    }
}

@Composable
fun Greeting() {
    val listOfData = listOf(

        FileData(
            subject_name = " सामान्य ज्ञान -1\n",
            file_name = "set-1.json",
            state_image = painterResource(R.drawable.book)
        ),
        FileData(
            subject_name = " सामान्य ज्ञान -2 \n",
            file_name = "set-2.json",
            state_image = painterResource(R.drawable.book)
        ),
        FileData(
            subject_name = " सामान्य ज्ञान -3\n",
            file_name = "set-3.json",
            state_image = painterResource(R.drawable.book)
        ),
        FileData(
            subject_name = " सामान्य ज्ञान -4\n",
            file_name = "set-4.json",
            state_image = painterResource(R.drawable.book)
        ),
        FileData(
            subject_name = " सामान्य ज्ञान -5\n",
            file_name = "set-5.json",
            state_image = painterResource(R.drawable.book)
        ),
        FileData(
            subject_name = " सामान्य ज्ञान -6\n",
            file_name = "set-6.json",
            state_image = painterResource(R.drawable.book)
        ),
        FileData(
            subject_name = " सामान्य ज्ञान -7\n",
            file_name = "set-7.json",
            state_image = painterResource(R.drawable.book)
        ),
        FileData(
            subject_name = " सामान्य ज्ञान -8\n",
            file_name = "set-10.json",
            state_image = painterResource(R.drawable.book)
        ),
         FileData(
            subject_name = " सामान्य ज्ञान -9\n",
            file_name = "set-11.json",
            state_image = painterResource(R.drawable.book)
        ),
         FileData(
            subject_name = " सामान्य ज्ञान -10\n",
            file_name = "set-12.json",
            state_image = painterResource(R.drawable.book)
        ),
         FileData(
            subject_name = " सामान्य ज्ञान -11\n",
            file_name = "set-13.json",
            state_image = painterResource(R.drawable.book)
        ),
        FileData(
            subject_name = " सामान्य ज्ञान -12\n",
            file_name = "set-14.json",
            state_image = painterResource(R.drawable.book)
        ),
        FileData(
            subject_name = " सामान्य ज्ञान -13\n",
            file_name = "set-15.json",
            state_image = painterResource(R.drawable.book)
        ),
        FileData(
            subject_name = " सामान्य ज्ञान -14\n",
            file_name = "set-16.json",
            state_image = painterResource(R.drawable.book)
        ),
        FileData(
            subject_name = " सामान्य ज्ञान -15\n",
            file_name = "set-17.json",
            state_image = painterResource(R.drawable.book)
        ),
        FileData(
            subject_name = "भूगोल सामान्य ज्ञान\n",
            file_name = "indian_geography_set_1.json",
            state_image = painterResource(R.drawable.geo)
        ),
        FileData(
            subject_name = "भूगोल सामान्य ज्ञान -2 \n",
            file_name = "indian_geography_set_2.json",
            state_image = painterResource(R.drawable.geo)
        ),
        FileData(
            subject_name = "भारत का संविधान\n",
            file_name = "indian_constitution_set_2.json",
            state_image = painterResource(R.drawable.india)
        ),
        FileData(
            subject_name = "Ten \n",
            file_name = "tenthousands.json",
            state_image = painterResource(R.drawable.india)
        ),
        FileData(
            subject_name = "पुरुस्कार सामान्य ज्ञान\n",
            file_name = "award.json",
            state_image = painterResource(R.drawable.trophy)
        ),
        FileData(
            subject_name = "विज्ञान सामान्य ज्ञान\n",
            file_name = "science_gk.json",
            state_image = painterResource(R.drawable.science)
        ),
        FileData(
            subject_name = "Gk In English",
            file_name = "gk_in_English.json",
            state_image = painterResource(R.drawable.eng)
        ),
        FileData(
            subject_name = "MCQ Quiz",
            file_name = "mcq_quiz",
            state_image = painterResource(R.drawable.eng)
        )
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
    ) {

        items(listOfData) { messages ->
            val context = LocalContext.current
            Card(modifier = Modifier
                .padding(10.dp)
                .clickable {
                    if(messages.file_name == "mcq_quiz"){
                        val intent = Intent(context, McqActivity::class.java)
                        context.startActivity(intent)
                    }
                    else{
                        val bundle = Bundle()
                        bundle.putString("file_name", messages.file_name)
                        val intent = Intent(context, QueAnsActivity::class.java)
                        intent.putExtras(bundle)
                        context.startActivity(intent)
                    }
                }
                , elevation = 10.dp){
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.height(30.dp))
                    Image(modifier = Modifier.size(60.dp) , painter =  messages.state_image, contentDescription = "Building image" )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = messages.subject_name, textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GKQuestionsAnswerTheme {
        Greeting()
    }
}