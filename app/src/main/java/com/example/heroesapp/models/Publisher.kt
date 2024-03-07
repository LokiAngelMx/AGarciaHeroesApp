package com.example.heroesapp.models

data class Publisher(val id: Int, val name: String, val image: String) {
    companion object {
        val publishers = mutableListOf<Publisher>(
            Publisher(1, "Marvel", "https://wallpapers.com/images/featured/marvel-logo-3p16v5avq80km4ns.jpg"),
            Publisher(2, "DC", "https://i.pinimg.com/originals/d7/98/a1/d798a1754c07acf44da605c7f1fec51c.jpg"),
            )
    }
}