package com.example.farmapp

import android.view.RoundedCorner
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmapp.ui.theme.*

@Composable
fun HomePage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(((-150 / 2)).dp)
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.home_page),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .size(150.dp)
                    .align(CenterHorizontally)
                    .clip(CircleShape)
                    .border(
                        BorderStroke(5.dp, GreenBorder),
                        CircleShape
                    )

            )
        }
        Spacer(modifier = Modifier.size(15.dp))
        Text(
            modifier = Modifier.align(CenterHorizontally),
            text = "Hi,",
            fontSize = 30.sp,
            color = HeadTextColor,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(25.dp))
        Text(
            modifier = Modifier.align(CenterHorizontally),
            text = "How can we Help?",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(30.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = ButtuonBackgroundColor),
            shape = RoundedCornerShape(50.dp)
        ) {
            Text(
                modifier = Modifier.padding(15.dp),
                text="provide advice on the best crop for my farm",
                color = BodyColorGreen
            )
        }
        Spacer(modifier = Modifier.size(30.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = ButtuonBackgroundColor),
            shape = RoundedCornerShape(50.dp)
        ) {
            Text(
                modifier = Modifier.padding(15.dp),
                text="Provide information about a particular crop.",
                color = BodyColorGreen
            )
        }
    }
}

@Preview
@Composable
fun HomePreview(){
    HomePage()
}