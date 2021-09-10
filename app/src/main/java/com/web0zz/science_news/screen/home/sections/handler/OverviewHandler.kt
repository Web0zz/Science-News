package com.web0zz.science_news.screen.home.sections.handler

data class Overview(
    val thumbnail_image: String,
    val name: String,
)

object OverviewHandler {
    val overview1 = Overview(
        "https://www.sciencenews.org/wp-content/uploads/2021/08/082821_reviews_fringe_feat-1030x580.jpg",
        "History"
    )
    val overview2 = Overview(
        "https://www.sciencenews.org/wp-content/uploads/2018/02/030318_organoids_main.jpg",
        "Human"
    )
    val overview3 = Overview(
        "https://www.sciencenews.org/wp-content/uploads/2017/09/091617_reviews_quake_main.jpg",
        "Earth"
    )
    val overview4 = Overview(
        "https://www.sciencenews.org/wp-content/uploads/2021/09/090221_rc_wildfire-smoke_feat-1030x580.jpg",
        "Weather"
    )
    val overview5 = Overview(
        "https://www.sciencenews.org/wp-content/uploads/2021/09/090721_jb_metal-mandibles_feat-1030x580.jpg",
        "Animals"
    )
}