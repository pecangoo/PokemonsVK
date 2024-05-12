package com.vk.pokemonapp.presenter.utils

object LinkMaker {
    fun returnImgLink(id:Int) : String {
        return "https://raw.githubusercontent.com" +
                "/PokeAPI/sprites/master/sprites/pokemon/${id}.png"
    }
}