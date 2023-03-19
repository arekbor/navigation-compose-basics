package pl.ar97.navigationcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import pl.ar97.navigationcompose.NavigationDestination
import pl.ar97.navigationcompose.getDestinationName

@Composable
fun HomeScreen(onClick: (String) -> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Home")
        Button(onClick = { onClick(NavigationDestination.Detail.getDestinationName()) }) {
            Text(text = "Detail")
        }
        Button(onClick = { onClick(NavigationDestination.Settings.getDestinationName()) }) {
            Text(text = "Settings")
        }
    }
}