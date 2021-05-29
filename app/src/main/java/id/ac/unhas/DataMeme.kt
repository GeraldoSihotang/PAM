package id.ac.unhas

data class DataMeme(
    val code: Int,
    val `data`: List<Data>,
    val message: String,
    val next: String
)

data class Data(
    val ID: Int,
    val bottomText: String,
    val image: String,
    val name: String,
    val rank: Int,
    val tags: String,
    val topText: String
)