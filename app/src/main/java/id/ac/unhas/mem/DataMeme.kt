package id.ac.unhas.mem

data class DataMeme(
    val page:Int,
    val result: List<meme>
)

data class meme(
    val text: String,
    val pics: String
)