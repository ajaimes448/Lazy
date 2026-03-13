package me.andresjaimes.lazycolumnlazyrowcoil.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import androidx.compose.ui.platform.LocalContext
import me.andresjaimes.lazycolumnlazyrowcoil.model.Post

@Composable
fun PostCard(
    post: Post,
    onLikeClick: (Post) -> Unit
) {
    var liked by remember { mutableStateOf(post.isLiked) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        PostHeader(post = post)

        // Imagen del post
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(post.imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = "Foto de ${post.username}",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            contentScale = ContentScale.Crop
        )

        PostActions(
            liked = liked,
            onLikeToggle = {
                liked = !liked
                onLikeClick(post.copy(isLiked = liked))
            }
        )

        PostFooter(post = post, liked = liked)
    }
}

@Composable
private fun PostHeader(post: Post) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = post.profileImageUrl,
            contentDescription = "Avatar de ${post.username}",
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = post.username,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = Icons.Default.MoreHoriz,
            contentDescription = "Más opciones"
        )
    }
}

@Composable
private fun PostActions(
    liked: Boolean,
    onLikeToggle: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // CORRECCIÓN: Usar íconos reales de Material Icons
        IconButton(onClick = onLikeToggle) {
            Icon(
                imageVector = if (liked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = if (liked) "Quitar like" else "Dar like",
                tint = if (liked) Color.Red else Color.Black
            )
        }

        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder, // Reemplazar con ícono de comentario si existe
                contentDescription = "Comentar",
                tint = Color.Black
            )
        }

        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = "Compartir",
                tint = Color.Black
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.BookmarkBorder,
                contentDescription = "Guardar",
                tint = Color.Black
            )
        }
    }
}

@Composable
private fun PostFooter(post: Post, liked: Boolean) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp).padding( bottom = 18.dp)
    ) {
        val likesCount = if (liked) post.likes + 1 else post.likes

        Text(
            text = "$likesCount Me gusta",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(post.username + " ")
                }
                append(post.caption)
            },
            fontSize = 14.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}