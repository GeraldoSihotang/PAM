package id.ac.unhas

class StaticData {
    companion object{
        var text: String = ""
        var pics: String = ""

        fun fill(meme: Data) {
            text = meme.name
            pics = meme.image
        }
    }
}