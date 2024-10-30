package com.example.readerapp.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.readerapp.R
import com.example.readerapp.model.MBook
import com.example.readerapp.navagation.ReaderScreens
import com.google.firebase.auth.FirebaseAuth

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ReaderHomeScreen(navController: NavController =NavController(LocalContext.current)) {
    Scaffold(topBar = {
        ReaderAppBar(title = "A.Reader", navController = navController)
    }, floatingActionButton = {
        FABContent {

        }
    }) {
        //content
        Surface(modifier = Modifier.fillMaxSize()) {
            //Home Content
            HomeContent(navController)
        }

    }
}

@Composable
fun HomeContent(navController: NavController){
    Column(modifier = Modifier.padding(2.dp),
        verticalArrangement = Arrangement.SpaceEvenly) {
        Row (modifier = Modifier.align(alignment = Alignment.Start)){
            TitleSection(label = "Your reading \n"+"activity right now... ")

        }

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderAppBar(
    title: String,
    showProfile: Boolean = true
    ,navController: NavController
) {
    TopAppBar(title = {
        Row(verticalAlignment = Alignment.CenterVertically){
            if (showProfile){
                Icon(imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "profile icon",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .scale(0.9f))
            }
            Text(text = title, color = Color.Red.copy(alpha = 0.7f),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
            )
            Spacer(modifier = Modifier.width(150.dp))
        }
    },

        actions ={
            IconButton(onClick = {  FirebaseAuth.getInstance().signOut().run{
                navController.navigate(ReaderScreens.LoginScreen.name)
            }
            }) {
                Icon(painter = painterResource(id = R.drawable.logout_icon)
                    , contentDescription ="icon Logout",
                   // tint = Color.Green.copy(alpha = 0.4f)
                )

            }
            
        }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = Color.Transparent,

    ))



}
@Composable
fun TitleSection(modifier: Modifier=Modifier,label:String){
    Surface(modifier=Modifier.padding(start = 5.dp,top=1.dp)) {
        Column {
            Text(text = label, fontSize = 19.sp
            , fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Left
            )
        }

    }
}
@Composable
fun ReadingRightNowArea(books:List<MBook>, navController: NavController){

}
@Composable
fun FABContent(onTap: (String) -> Unit) {
    FloatingActionButton(
        onClick = { onTap },
        shape = RoundedCornerShape(50.dp), containerColor = Color(0xFF92CBDF),
    ) {
        Icon(
            imageVector = Icons.Default.Add, contentDescription = "ICon Add", tint = Color.White
        )
    }

}


