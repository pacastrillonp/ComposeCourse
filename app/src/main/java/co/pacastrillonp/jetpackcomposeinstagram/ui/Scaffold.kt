package co.pacastrillonp.jetpackcomposeinstagram.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.pacastrillonp.jetpackcomposeinstagram.ui.theme.JetpackComposeInstagramTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldExample() {
    val scaffoldState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(scaffoldState) },
        topBar = {
            MyTopAppBar { iconName ->
                coroutineScope.launch {
                    scaffoldState.showSnackbar(
                        iconName
                    )
                }
            }
        },
        bottomBar = { MyBottomNavigation() },
        floatingActionButton = { MyFab() },
        floatingActionButtonPosition = FabPosition.Center,

    )
    {

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onIconClick: (String) -> Unit) {
    TopAppBar(
        title = {
            Text(text = "Mi primera toolbar")
        }, colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.White,
        ),
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { onIconClick("Search") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = { onIconClick("Dangerous") }) {
                Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "Dangerous")
            }
        }
    )
}

@Composable
fun MyBottomNavigation() {
    var index by remember { mutableStateOf(0) }
    NavigationBar(containerColor = Color.Red, contentColor = Color.White) {
        NavigationBarItem(
            selected = index == 0,
            onClick = { index = 0 },
            label = { Text(text = "Home") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "home"
                )
            })
        NavigationBarItem(
            selected = index == 1,
            onClick = { index = 1 },
            label = { Text(text = "Home") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite"
                )
            })
        NavigationBarItem(
            selected = index == 2,
            onClick = { index = 2 },
            label = { Text(text = "Home") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person"
                )
            })
    }
}

@Composable
fun MyFab() {
    FloatingActionButton(onClick = {}, containerColor = Color.Yellow, contentColor = Color.Black) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScaffoldExamplePreview() {
    JetpackComposeInstagramTheme {
        ScaffoldExample()
    }
}
