package com.vk.pokemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vk.pokemonapp.domain.GetInfoPokemonUseCase
import com.vk.pokemonapp.domain.GetListPokemonUseCase
import com.vk.pokemonapp.network.repository.PokemonListRepository
import com.vk.pokemonapp.presenter.screen.PokemonInfoScreen
import com.vk.pokemonapp.presenter.screen.PokemonListScreen
import com.vk.pokemonapp.presenter.screen.SecretPage
import com.vk.pokemonapp.presenter.vm.PokemonInfoScreenVM
import com.vk.pokemonapp.presenter.vm.PokemonListScreenVM
import com.vk.pokemonapp.presenter.vm.factory.PokemonInfoScreenVMFactory
import com.vk.pokemonapp.presenter.vm.factory.PokemonListScreenVMFactory
import com.vk.pokemonapp.ui.theme.PokemonAppTheme

class MainActivity : ComponentActivity() {

    lateinit var listScreenVM: PokemonListScreenVM
    lateinit var listScreenVMFactory: PokemonListScreenVMFactory

    lateinit var infoScreenVM: PokemonInfoScreenVM
    lateinit var infoScreenVMFactory: PokemonInfoScreenVMFactory


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        listScreenVMFactory = PokemonListScreenVMFactory(
            GetListPokemonUseCase(),
            PokemonListRepository()
        )
        listScreenVM = ViewModelProvider(this, listScreenVMFactory)
            .get(PokemonListScreenVM::class.java);


        infoScreenVMFactory = PokemonInfoScreenVMFactory(
            GetInfoPokemonUseCase(),
            PokemonListRepository()
        )
        infoScreenVM = ViewModelProvider(this, infoScreenVMFactory)
            .get(PokemonInfoScreenVM::class.java);


        setContent {
            val navController = rememberNavController()


            PokemonAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    NavHost(navController = navController,
                        startDestination = "pokemon_list") {
                        composable("pokemon_list") {
                            PokemonListScreen(listScreenVM) { navController.navigate(it) };
                        }
                        composable("pokemon_info/{id}") {
                            id ->
                           val pokemonId = id.arguments?.getString("id")
                            PokemonInfoScreen(infoScreenVM,
                                id = pokemonId) { navController.navigate(it) };
                        }
                        composable("secret_page"){
                            SecretPage()
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokemonAppTheme {
        Greeting("Android")
    }
}