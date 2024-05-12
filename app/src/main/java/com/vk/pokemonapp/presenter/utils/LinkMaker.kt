package com.vk.pokemonapp.presenter.utils

object LinkMaker {
    fun returnImgLink(id:String) : String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id}.png"
    }
}