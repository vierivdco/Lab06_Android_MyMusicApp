package com.cervantes.mymusicapp.model

data class Repository(val musics:MutableList<Music> = ArrayList()) {

    init {
        getDataMusics()
    }

    fun getDataMusics(): List<Music> {
        musics.add(Music(1, "Stronger", "Kanye West", "ic_artist_1", "Hip Hop"))
        musics.add(Music(2, "Taboo", "Don Omar", "ic_artist_2", "Reggaeton"))
        musics.add(Music(3, "Alive", "Warbly Jets", "ic_artist_3", "rock"))
        musics.add(Music(4, "Blinding Lights", "The Weekend", "ic_artist_4", "Pop"))
        musics.add(Music(5, "Virgen", "Adolescent's Orquesta", "ic_artist_5", "Salsa"))
        musics.add(Music(6, "Sphere", "Creo", "ic_artist_6", "Electro music"))
        musics.add(Music(7, "Zombie", "The Cranberries", "ic_artist_7", "rock"))
        musics.add(Music(8, "Fury Of The Storm", "DragonForce", "ic_artist_8", "rock"))
        return musics
    }
}
