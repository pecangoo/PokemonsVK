package com.vk.pokemonapp.presenter.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.vk.pokemonapp.network.model.Type
import com.vk.pokemonapp.presenter.utils.ColorsTypes

@Composable
fun AsyncImage(url: String, size:Int = 100) {
    val painter = rememberImagePainter(url)

    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier.size(size.dp)
    )
}



@Composable
fun TypeRow(types: List<Type>?) {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
     //   ColoredRectangle()
        if (types != null) {
            types.forEach {
                ColoredRectangle(colorHex = ColorsTypes.pokemonTypesColors.get(it.type.name)!!,
                    label = it.type.name)
            }
        }


    }
}

@Composable
fun ColoredRectangle(colorHex: String, label: String) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(
                Color(android.graphics.Color.parseColor(colorHex)),
                shape = RoundedCornerShape(40.dp)
            )
            .width(75.dp),
        contentAlignment = Alignment.Center
    ) {
            Text(
                text = label,
                modifier = Modifier.padding(8.dp)
                //  color = Color.Black
            )
        }

}
