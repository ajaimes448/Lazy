package me.andresjaimes.lazycolumnlazyrowcoil.data

import me.andresjaimes.lazycolumnlazyrowcoil.model.Post
import me.andresjaimes.lazycolumnlazyrowcoil.model.Story

object DataSource {

    fun getPosts(): List<Post> = listOf(
        Post(
            id = 1,
            username = "kotlin_ninja",
            profileImageUrl = "https://picsum.photos/seed/user1/200/200",
            imageUrl = "https://picsum.photos/seed/post1/800/800",
            likes = 1234,
            caption = "Aprendiendo Jetpack Compose! 🚀 #Kotlin #AndroidDev",
            isLiked = false
        ),
        Post(
            id = 2,
            username = "android_dev",
            profileImageUrl = "https://picsum.photos/seed/user2/200/200",
            imageUrl = "https://picsum.photos/seed/post2/800/800",
            likes = 2345,
            caption = "LazyColumn es increíble para feeds eficientes 🔥",
            isLiked = true
        ),
        Post(
            id = 3,
            username = "compose_fan",
            profileImageUrl = "https://picsum.photos/seed/user3/200/200",
            imageUrl = "https://picsum.photos/seed/post3/800/800",
            likes = 3456,
            caption = "Coil + Compose = ❤️",
            isLiked = false
        ),
        Post(
            id = 4,
            username = "google_io",
            profileImageUrl = "https://picsum.photos/seed/user4/200/200",
            imageUrl = "https://picsum.photos/seed/post4/800/800",
            likes = 4567,
            caption = "Material 3 ya está disponible",
            isLiked = true
        ),
        Post(
            id = 5,
            username = "kotlin_weekly",
            profileImageUrl = "https://picsum.photos/seed/user5/200/200",
            imageUrl = "https://picsum.photos/seed/post5/800/800",
            likes = 5678,
            caption = "Novedades en Kotlin 2.0",
            isLiked = false
        ),
        Post(
            id = 6,
            username = "ux_android",
            profileImageUrl = "https://picsum.photos/seed/user6/200/200",
            imageUrl = "https://picsum.photos/seed/post6/800/800",
            likes = 2103,
            caption = "Animaciones fluidas con animateAsState 🎭",
            isLiked = true
        ),
        Post(
            id = 7,
            username = "dev_colombia",
            profileImageUrl = "https://picsum.photos/seed/user7/200/200",
            imageUrl = "https://picsum.photos/seed/post7/800/800",
            likes = 445,
            caption = "Coil hace super fácil cargar imágenes en Compose 📸",
            isLiked = false
        ),
        Post(
            id = 8,
            username = "android_studio",
            profileImageUrl = "https://picsum.photos/seed/user8/200/200",
            imageUrl = "https://picsum.photos/seed/post8/800/800",
            likes = 789,
            caption = "Nuevas funcionalidades en Hedgehog 🦔",
            isLiked = true
        ),
        Post(
            id = 9,
            username = "tech_latam",
            profileImageUrl = "https://picsum.photos/seed/user9/200/200",
            imageUrl = "https://picsum.photos/seed/post9/800/800",
            likes = 1230,
            caption = "Comunidad Android en crecimiento 🌎",
            isLiked = false
        ),
        Post(
            id = 10,
            username = "programming_memes",
            profileImageUrl = "https://picsum.photos/seed/user10/200/200",
            imageUrl = "https://picsum.photos/seed/post10/800/800",
            likes = 3421,
            caption = "Cuando el código compila a la primera... 😂",
            isLiked = false
        )
    )

    fun getStories(): List<Story> = listOf(
        Story(1, "Tu historia", "", hasSeen = false),
        Story(2, "android_dev", "https://picsum.photos/seed/s2/200/200", hasSeen = false),
        Story(3, "kotlin_fan", "https://picsum.photos/seed/s3/200/200", hasSeen = false),
        Story(4, "google_io", "https://picsum.photos/seed/s4/200/200", hasSeen = true),
        Story(5, "compose_master", "https://picsum.photos/seed/s5/200/200", hasSeen = false),
        Story(6, "android_weekly", "https://picsum.photos/seed/s6/200/200", hasSeen = true),
        Story(7, "dev_community", "https://picsum.photos/seed/s7/200/200", hasSeen = false)
    )
}