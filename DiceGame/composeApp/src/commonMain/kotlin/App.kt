
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dicegame.composeapp.generated.resources.Res
import dicegame.composeapp.generated.resources.compose_multiplatform
import dicegame.composeapp.generated.resources.dice_1
import dicegame.composeapp.generated.resources.dice_2
import dicegame.composeapp.generated.resources.dice_3
import dicegame.composeapp.generated.resources.dice_4
import dicegame.composeapp.generated.resources.dice_5
import dicegame.composeapp.generated.resources.dice_6
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.random.Random

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            DiceRollerApp()
        }
    }
      /*  var result by remember { mutableStateOf( 1) }
        var image : DrawableResource = Res.drawable.dice_2

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome to World of Dice")

            Image(painterResource(image), contentDescription = null)

            Button(
                onClick = {
                     result = (1..6).random()
                   when(result){
                       1 -> image = Res.drawable.dice_1
                       2 -> image = Res.drawable.dice_2
                       3 -> image = Res.drawable.dice_3
                       4 -> image = Res.drawable.dice_4
                       5 -> image = Res.drawable.dice_5
                       6 -> image = Res.drawable.dice_6
                       else -> image = Res.drawable.compose_multiplatform
                   }
                }
            ) {
                Text("Roll the Dice")
            }
        }
    } */
}

    @Preview
    @Composable
    fun DiceRollerApp() {
        DiceWithButtonAndImage(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
        )
    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
        var result by remember { mutableStateOf( 1) }
        val imageResource = when(result) {
            1 -> Res.drawable.dice_1
            2 -> Res.drawable.dice_2
            3 -> Res.drawable.dice_3
            4 -> Res.drawable.dice_4
            5 -> Res.drawable.dice_5
            else -> Res.drawable.dice_6
        }
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Welcome To World Of Dice", fontSize = 20.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.ExtraBold)
            Image(painter = painterResource(imageResource), contentDescription = result.toString())

            Button(
                onClick = { result = (1..6).random() },
            ) {
                Text(text = "Roll the Dice", fontSize = 24.sp)
            }
        }
    }
