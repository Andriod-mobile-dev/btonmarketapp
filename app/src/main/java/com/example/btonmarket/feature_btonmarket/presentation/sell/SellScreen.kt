package com.example.btonmarket.feature_btonmarket.presentation.sell

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btonmarket.feature_btonmarket.data.data_source.remote.sellItem
import com.example.btonmarket.feature_btonmarket.domain.model.SellViewModel
import kotlin.math.roundToInt


@Composable
fun SellScreen(sellVm: SellViewModel){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(0.dp,50.dp,0.dp,0.dp)
        ) {
            pageTitle(title = "Sell Item")
        }
        Row(
            modifier = Modifier
                .width(300.dp)
                .padding(0.dp, 20.dp)
        ) {
            sell(sellVm)
        }
    }
}

@Composable
fun sell(sellVm: SellViewModel){
    var name by remember {
        mutableStateOf("")
    }
    var seller by remember {
        mutableStateOf("")
    }
    var condition by remember {
        mutableStateOf("")
    }
    var price by remember {
        mutableStateOf(10.00f)
    }
    var negotiable by remember {
        mutableStateOf(false)
    }
    // boolean sold: not needed here
    val sold by remember {
        mutableStateOf(false)
    }
    var img by remember {
        mutableStateOf("")
    }
    var sending by remember {
        mutableStateOf(false)
    }
    // state to call the suspend function
    if (sending){
        Log.d("Debug Tesfa", "Launching effect")
        LaunchedEffect(key1 = Unit, block = {
            //Todo: view model call goes here
            sellVm.postSellItem(sellItem(name, seller, condition, price, negotiable,sold, img))
            name = ""
            seller = ""
            condition = ""
            price = 10f
            negotiable = false
            img = ""
            Log.d("Sent sell post request", sellItem(name, seller, condition, price, negotiable,sold, img).toString())
        })
        sending = false // todo: not sure about this
    }

    Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SellForm(name, updateName = { nameInput ->
                name = nameInput
            },
                seller,
                updateSeller = {
                    seller = it
                },
                condition,
                updateCondition = {
                    condition = it
                },
                price,
                updatePrice = {
                    price = it
                },
                negotiable,
                updateNegotiable = {
                    negotiable = it
                },
                img,
                updateImg = {
                    img = it
                }
            )

            Button(
                onClick = {
                    sending = true
//                    name = ""
//                    seller = ""
//                    condition = ""
//                    price = 10f
//                    negotiable = false
//                    img = ""

                }
            ) {
                Text(text = "Put on sell")
            }
        }
}

//var name: String,
//var seller: String,
//var condition: String,
//var price : Float,
//var negotiable : Boolean,
//var sold: Boolean,
//var img: String,
@Composable
fun SellForm(name:String,
             updateName:(String)->Unit,
             seller:String,
             updateSeller:(String)->Unit,
             condition:String,
             updateCondition:(String)->Unit,
             price: Float,
             updatePrice:(Float)->Unit,
             negotiable: Boolean,
             updateNegotiable:(Boolean)->Unit,
             img:String,
             updateImg:(String)->Unit,
){
    CustomOutlinedTextInputField(field = name, "Item name", updateFieldName = updateName)
    CustomOutlinedTextInputField(field = seller, "Seller name", updateFieldName = updateSeller)
    CustomOutlinedTextInputField(field = condition, "Condition", updateFieldName = updateCondition)
    CustomOutlinedTextInputField(field = img, "Image", updateFieldName = updateImg)
    CustomSlider(value = price, from = .0f, to = 100.0f, updateValue = updatePrice)
    Label(lableText = "${(price)} usd", align = TextAlign.Start)
    Toggle(negotiable,"Negotiable", updateValue = updateNegotiable)
}

//Todo: Global composable
@Composable
fun pageTitle(title:String){
    Text(
        text = title,
        color = MaterialTheme.colors.primary,
        fontSize = 30.sp,
        fontWeight = FontWeight.ExtraBold,
        maxLines = 1
    )
}

@Composable
fun Toggle(value:Boolean,name:String, updateValue: (Boolean) -> Unit){
    Row(
        modifier = Modifier.padding(0.dp, 15.dp)
    ){
        Column(
            modifier = Modifier.padding(7.dp, 10.dp)
        ){
            Label(lableText = name, align = TextAlign.Start)
        }
        Column {
            Switch(
                checked = value,
                onCheckedChange = { updateValue(it) }
            )
        }
    }
}
@Composable
fun Label(lableText:String, align: TextAlign){
    Text(
        text = lableText,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        textAlign = align,
        color = Color.Black,
    )
}

// Todo: Util function
fun roundToTwoDecimalPlace(number: Float) : Float{
    val roundoff = (number * 100.0).roundToInt() / 100.0
    return roundoff.toFloat()
}

@Composable
fun CustomSlider(value: Float,from:Float, to:Float, updateValue:(Float)->Unit){
    Slider(
        value = value,
        onValueChange = {
            updateValue(roundToTwoDecimalPlace(it))
        },
        valueRange = from .. to,
        onValueChangeFinished = {
            //ignore
        },
        steps = 0,
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colors.primaryVariant,
            activeTickColor = MaterialTheme.colors.primaryVariant,
            disabledThumbColor = MaterialTheme.colors.primaryVariant,
        )
    )
}

@Composable
fun CustomOutlinedTextInputField(field:String,
                                 lableName:String,
                                 updateFieldName: (String) -> Unit){
    Log.d("updating value", field)
    OutlinedTextField(
        value = field,
        onValueChange = {updateFieldName(it)},
        label = {
                Text(text = lableName)
        },
        singleLine = true,
        // outlined text color
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.secondary,
            unfocusedBorderColor = MaterialTheme.colors.secondary,
            focusedLabelColor = MaterialTheme.colors.secondary,
            cursorColor = MaterialTheme.colors.primaryVariant
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        // validation
        isError = false,
        //modifier = Modifier.width(300.dp)
    )
}


@Composable
@Preview
fun SellScreenPreview(){
    //SellScreen()
}