package com.example.tugasnavigasi

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tugasnavigasi.view.BerandaScreen
import com.example.tugasnavigasi.view.FormulirPendaftaranScreen
import com.example.tugasnavigasi.view.ListPesertaScreen

enum class Navigasi {
    Beranda,
    Formulir,
    List
}
@Composable
fun AplikasiPendaftaranApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier) { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Beranda.name,
            modifier = Modifier.padding(isiRuang)
        ) {
            composable(route = Navigasi.Beranda.name) {
                BerandaScreen(
                    onSubmitClick = {
                        navController.navigate(Navigasi.Formulir.name)
                    }
                )
            }
            composable(route = Navigasi.Formulir.name) {
                FormulirPendaftaranScreen(
                    onSubmitClick = { nama, jk, status, alamat ->
                        navController.navigate("${Navigasi.List.name}/$nama/$jk/$status/$alamat")
                    }
                )
            }
            val routeList = "${Navigasi.List.name}/{nama}/{jk}/{status}/{alamat}"
            composable(
                route = routeList,
                arguments = listOf(
                    navArgument("nama") { type = NavType.StringType },
                    navArgument("jk") { type = NavType.StringType },
                    navArgument("status") { type = NavType.StringType },
                    navArgument("alamat") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val nama = backStackEntry.arguments?.getString("nama") ?: ""
                val jk = backStackEntry.arguments?.getString("jk") ?: ""
                val status = backStackEntry.arguments?.getString("status") ?: ""
                val alamat = backStackEntry.arguments?.getString("alamat") ?: ""

                ListPesertaScreen(
                    nama = nama,
                    jenisKelamin = jk,
                    statusPerkawinan = status,
                    alamat = alamat,
                    onBerandaClick = {
                        kembaliKeBeranda(navController)
                    },
                    onFormulirClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
private fun kembaliKeBeranda(navController: NavHostController) {
    navController.navigate(Navigasi.Beranda.name) {
        popUpTo(Navigasi.Beranda.name) {
            inclusive = true
        }
    }
}