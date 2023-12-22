package views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Hospitals(navController: NavController){
    var isexpanded by remember {
        mutableStateOf(false)
    }
    var city by remember {
        mutableStateOf("")
    }

    val fontFamily = FontFamily(
        Font(R.font.wendyoneregular, FontWeight.Thin))

    Column(modifier = Modifier.fillMaxSize()){

        Box(modifier = Modifier
            .fillMaxWidth()
            .size(100.dp)
            .background(color = Color(0xFF2697FF))){
            Text(text = "Hospitals",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 70.dp, top = 25.dp),

                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Start,
                    fontFamily = fontFamily,
                fontSize = 26.sp)


            Box(modifier = Modifier

                .padding(10.dp)
                .clickable {
                    navController.navigate(route = "patient_home")

                }) {
                LocalImage(
                    painter = painterResource(id = R.drawable.whitearrow), imageSize = 60.dp,
                    padding = 10.dp
                )
            }
        }
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxSize()
        ){
            ExposedDropdownMenuBox(
                expanded = isexpanded,
                onExpandedChange = {isexpanded = it}) {
                OutlinedTextField(value = city,
                    onValueChange = {},
                    readOnly = true,
                    label = {
                        Text(
                            text = "Select your city",
                            color = Color.LightGray
                        )
                    },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isexpanded)},
                    modifier = Modifier
                        .menuAnchor()
                        .background(color = Color(0xFFFFFFFF)),
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.lightblue),
                        focusedBorderColor = colorResource(id = R.color.lightblue)
                    )
                )
                ExposedDropdownMenu(
                    expanded = isexpanded,
                    onDismissRequest = { isexpanded = false }) {
                    DropdownMenuItem(
                        text = {Text(text = "Tanta") },
                        onClick = {
                            city = "Tanta"
                            isexpanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = {Text(text = "Mahala") },
                        onClick = {
                            city = "Mahala"
                            isexpanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = {Text(text = "Kafr elziat") },
                        onClick = {
                            city = "Kafr elziat"
                            isexpanded = false
                        }
                    )

                }

            }
        }
        }
}



@Composable
@Preview(showBackground = true)
fun HosPreview(){
    Hospitals(navController = rememberNavController())
}