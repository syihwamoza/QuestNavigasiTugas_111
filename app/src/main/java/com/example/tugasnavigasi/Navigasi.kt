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
