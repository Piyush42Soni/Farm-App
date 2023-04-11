package com.example.farmapp

import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmapp.ml.Tflitecropmodel
import com.example.farmapp.ui.theme.*
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer
import java.nio.ByteOrder

fun GetOutput(context:Context,InputData:List<Float>): FloatArray? {
    val model = Tflitecropmodel.newInstance(context)
    val byteBuffer = ByteBuffer.allocateDirect(7*4)
    byteBuffer.order(ByteOrder.nativeOrder())
    val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 7), DataType.FLOAT32)
    for(i in 0 until 7) {
        byteBuffer.putFloat(InputData[i])
    }
    inputFeature0.loadBuffer(byteBuffer)
// Creates inputs for reference.
    inputFeature0.loadBuffer(byteBuffer)

// Runs model inference and gets result.
    val outputs = model.process(inputFeature0)
    val outputFeature0 = outputs.outputFeature0AsTensorBuffer
    val data1 = outputFeature0.floatArray
// Releases model resources if no longer used.
    model.close()
    return data1
}
@Composable
fun PredictPage() {
    val Crop= listOf<String>("apple",
        "banana",
        "blackgram",
        "chickpea",
        "coconut",
        "coffee",
        "cotton",
        "grapes",
        "jute",
        "kidneybeans",
        "lentil",
        "maize",
        "mango",
        "mothbeans",
        "mungbean",
        "muskmelon",
        "orange",
        "papaya",
        "pigeonpeas",
        "pomegranate",
        "rice",
        "watermelon"
    )
    var PredictIndex by remember{
        mutableStateOf(R.drawable.logo)
    }
    var PredictText by remember{
        mutableStateOf("Enter the following info to get best possible prediction for your farm")
    }
    var Nitrogen by remember{
        mutableStateOf("")
    }
    var Potassium by remember{
        mutableStateOf("")
    }
    var Phosphorus by remember{
        mutableStateOf("")
    }
    var Temprature by remember{
        mutableStateOf("")
    }
    var Ph by remember{
        mutableStateOf("")
    }
    var Humidity by remember{
        mutableStateOf("")
    }
    var RainFall by remember{
        mutableStateOf("")
    }
    val context=LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .background(BackgroundColor)
        .verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(((-100 / 2)).dp)
            ) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.info_page),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth
                )
                Image(
                    painter = painterResource(id = PredictIndex),
                    contentDescription = "",
                    modifier = Modifier
                        .size(150.dp)
                        .align(Alignment.CenterHorizontally)
                        .clip(CircleShape)
                        .border(
                            BorderStroke(5.dp, GreenBorder),
                            CircleShape
                        )
                )
            }
            Spacer(modifier = Modifier.size(25.dp))
            Text(
                modifier = Modifier,
                text = PredictText,
                fontSize = 23.sp,
                color = HeadTextColor,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            modifier = Modifier,
            text = "Provide Nitrogen Present in Land",
            fontSize = 15.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(value = Nitrogen.toString(), onValueChange ={Nitrogen=it})

        Spacer(modifier = Modifier.size(20.dp))
        Text(
            modifier = Modifier,
            text = "Provide potassium Present in Land",
            fontSize = 15.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(value = Potassium.toString(), onValueChange ={Potassium=it})
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            modifier = Modifier,
            text = "Provide phosphorus Present in Land",
            fontSize = 15.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(value = Phosphorus.toString(), onValueChange ={Phosphorus=it})

        Spacer(modifier = Modifier.size(20.dp))
        Text(
            modifier = Modifier,
            text = "Enter temperature of your Farm",
            fontSize = 15.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(value = Temprature.toString(), onValueChange ={Temprature=it})

        Spacer(modifier = Modifier.size(20.dp))
        Text(
            modifier = Modifier,
            text = "Enter Humidity of your Farm atmosphere ",
            fontSize = 15.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(value = Humidity.toString(), onValueChange ={Humidity=it})

        Spacer(modifier = Modifier.size(20.dp))
        Text(
            modifier = Modifier,
            text = "Enter Enter ph of your Farm Land ",
            fontSize = 15.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(value = Ph.toString(), onValueChange ={Ph=it})

        Spacer(modifier = Modifier.size(20.dp))
        Text(
            modifier = Modifier,
            text = "Enter rainfall in your Farm locality",
            fontSize = 15.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(value = RainFall.toString(), onValueChange ={RainFall=it})
        Spacer(modifier = Modifier.size(20.dp))

        Button(
            onClick = {
                var Nitrogen1 = Nitrogen.toFloat()/(140f)
                var Phosphorus1=((Phosphorus.toFloat()-5f)/(140f))
                var Potassium1=((Potassium.toFloat()-5f)/(200f))
                var Temprature1=((Temprature.toFloat()-8.825675f)/(43.67549f -8.825675f))
                var Humidity1=((Humidity.toFloat()-14.25804f)/(99.98187f -14.25804f))
                var Ph1=((Ph.toFloat()-3.504752f)/(9.935091f-3.504752f))
                var RainFall1=((RainFall.toFloat()-20.211267f)/(298.56012f -20.211267f))
                val inputList= listOf<Float>(Nitrogen1,Phosphorus1,Potassium1,Temprature1,Humidity1,Ph1,RainFall1)
                val x=GetOutput(context=context,inputList)
                val max = x?.max()
                val maxIdx = x?.indices?.find { i -> x[i] == max } ?: -1
                PredictText="${Crop[maxIdx]} is Prefered by our DL model"
                PredictIndex=when(maxIdx){
                    0->R.drawable.apple
                    1->R.drawable.banana
                    2->R.drawable.blackgram
                    3->R.drawable.chickpea
                    4->R.drawable.coconut
                    5->R.drawable.coffee
                    6->R.drawable.cotton
                    7->R.drawable.grapes
                    8->R.drawable.jute
                    9->R.drawable.kidneybeans
                    10->R.drawable.lentil
                    11->R.drawable.maize
                    12->R.drawable.mango
                    13->R.drawable.mothbeans
                    14->R.drawable.mungbean
                    15->R.drawable.muskmelon
                    16->R.drawable.orange
                    17->R.drawable.papaya
                    18->R.drawable.pigeonpeas
                    19->R.drawable.pomegranate
                    20->R.drawable.rice
                    21->R.drawable.watermelon
                    else -> {R.drawable.logo}
                }
                      },
            colors = ButtonDefaults.buttonColors(backgroundColor = ButtuonBackgroundColor),
            shape = RoundedCornerShape(50.dp)
        ) {
            Text(
                modifier = Modifier.padding(15.dp),
                text="Submit",
                color = BodyColorGreen
            )
        }
    }
}

@Preview
@Composable
fun PredictPreview(){
    PredictPage()
}