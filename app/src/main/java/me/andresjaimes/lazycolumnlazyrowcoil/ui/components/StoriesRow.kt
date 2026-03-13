package me.andresjaimes.lazycolumnlazyrowcoil.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import me.andresjaimes.lazycolumnlazyrowcoil.model.Story

@Composable
fun StoriesRow(stories: List<Story>) {
    LazyRow(
        modifier = Modifier.padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(stories) { story ->
            StoryItem(story = story)
        }
    }
}
@Composable
fun StoryItem(story: Story) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(68.dp)
    ) {
        // Avatar con anillo de historia
        AsyncImage(
            model = story.profileImageUrl,
            contentDescription = "Story de ${story.username}",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .then(
                    if (!story.hasSeen && story.id != 1) {
                        Modifier.border(
                            width = 2.dp,
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFFF77737), Color(0xFFE1306C))
                            ),
                            shape = CircleShape
                        )
                    } else if (story.id == 1) {
                        Modifier.border(
                            width = 2.dp,
                            color = Color.Gray,
                            shape = CircleShape
                        )
                    } else {
                        Modifier
                    }
                ),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = if (story.id == 1) "Tu historia" else story.username,
            fontSize = 11.sp,
            maxLines = 1
        )
    }
}