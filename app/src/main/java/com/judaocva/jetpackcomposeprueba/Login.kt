package com.judaocva.jetpackcomposeprueba

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun Login() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LoginImage()
        LoginTitleText()
        LoginSubtitleText()
        LoginFields()
        Button(
            text = stringResource(R.string.IngresarLabel),
            btnColors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.orange)),
            textColor = colorResource(R.color.white),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(top = 40.dp)
                .height(45.dp)
        )
        Button(
            text = stringResource(R.string.ConfiguracionLabel),
            btnColors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.white)
            ),
            textColor = colorResource(R.color.black),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(top = 15.dp)
                .height(45.dp)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(20.dp)
                )
        )
    }
}

@Composable
fun LoginImage() {
    val imageResource = painterResource(id = R.drawable.ic_launcher_foreground)
    Image(
        painter = imageResource,
        contentDescription = "RecargaMe com.judaocva.jetpackcomposeprueba.Login Image",
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(top = 16.dp)
    )
}

@Composable
fun LoginTitleText() {
    Text(
        text = stringResource(R.string.LoginTitle),
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        style = TextStyle(
            color = Color.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    )
}

@Composable
fun LoginSubtitleText() {
    Text(
        text = stringResource(R.string.LoginSubtitle),
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth(),
        style = TextStyle(
            color = Color.Gray, fontSize = 13.sp,
            textAlign = TextAlign.Center
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginFields() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
    ) {
        Text(
            text = stringResource(R.string.Usuario),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 15.dp, bottom = 5.dp),
            style = TextStyle(
                color = Color.Gray, fontSize = 13.sp
            )
        )
        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            singleLine = true,
            onValueChange = { newText -> text = newText },
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .clip(MaterialTheme.shapes.extraLarge)
                .height(50.dp),
            textStyle = TextStyle(fontSize = 15.sp),
            colors = textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Text(
            text = stringResource(R.string.Contrasena),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 15.dp, top = 15.dp, bottom = 5.dp),
            style = TextStyle(
                color = Color.Gray, fontSize = 13.sp
            )
        )
        var passwordText by remember { mutableStateOf("") }
        var passwordVisibility by remember { mutableStateOf(false) }
        TextField(
            value = passwordText,
            singleLine = true,
            onValueChange = { newText -> passwordText = newText },
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .clip(MaterialTheme.shapes.extraLarge)
                .height(50.dp),
            textStyle = TextStyle(fontSize = 15.sp),
            colors = textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            trailingIcon = {
                IconButton(
                    onClick = {
                        passwordVisibility = !passwordVisibility
                    }
                ) {
                    val icon =
                        if (passwordVisibility) Icons.Default.Lock else Icons.Default.Info
                    Icon(
                        imageVector = icon,
                        contentDescription = "Toggle password visibility"
                    )
                }
            }
        )
    }
}

