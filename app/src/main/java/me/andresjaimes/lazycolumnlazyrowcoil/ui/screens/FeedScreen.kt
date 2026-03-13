package me.andresjaimes.lazycolumnlazyrowcoil.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Send

// CORRECCIÓN 1: Importaciones correctas
import me.andresjaimes.lazycolumnlazyrowcoil.data.DataSource
import me.andresjaimes.lazycolumnlazyrowcoil.ui.components.PostCard  // CORRECCIÓN 2: Faltaba esta importación
import me.andresjaimes.lazycolumnlazyrowcoil.ui.components.StoriesRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen() {
    val posts by remember { mutableStateOf(DataSource.getPosts()) }
    val stories by remember { mutableStateOf(DataSource.getStories()) }

    Scaffold(
        topBar = { InstagramTopBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            state = rememberLazyListState()
        ) {
            // Stories row como item único
            item(key = "stories_row") {
                StoriesRow(stories = stories)
                Divider()
            }

            // CORRECCIÓN 3: Aquí debe ser PostCard, NO StoriesRow
            items(
                items = posts,
                key = { post -> post.id }
            ) { post ->
                PostCard(  // CORRECCIÓN: Cambiado de StoriesRow a PostCard
                    post = post,
                    onLikeClick = { likedPost ->
                        // CORRECCIÓN 4: usernam -> username
                        println("Like en: ${likedPost.username}")
                    }
                )
            }

            // Footer al final del feed
            item(key = "feed_footer") {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 24.dp)
                ) {
                    Text(
                        text = "✨ Has llegado al final ✨",
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Instagram",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                fontFamily = FontFamily.Cursive
            )
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Notifications")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.Send, contentDescription = "Messages")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )
    )
}