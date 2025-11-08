package com.example.navigasi_tugas

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasi_tugas.view.Beranda
import com.example.navigasi_tugas.view.FormIsian
import com.example.navigasi_tugas.view.ListParticipant


object Routes {
    const val Beranda = "beranda"
    const val ListParticipant = "list_participant"
    const val FormIsian = "form_isian"
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.Beranda,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.Beranda) {
                Beranda(
                    onStartClick = {
                        navController.navigate(Routes.ListParticipant)
                    }
                )
            }
            composable(Routes.ListParticipant) {
                ListParticipant(
                    onBerandaClick = {
                        cancelAndBackToBeranda(navController)
                    },
                    onFormulirClick = {
                        navController.navigate(Routes.FormIsian)
                    }
                )
            }
            composable(Routes.FormIsian) {
                FormIsian(
                    onSubmit = { nama, gender, status, alamat ->
                    },
                    onSelesaiDialog = {
                    },
                    onBerandaClick = {
                        cancelAndBackToBeranda(navController)
                    }
                )
            }
        }
    }
}

private fun cancelAndBackToBeranda(navController: NavHostController) {
    navController.popBackStack(
        Routes.Beranda,
        inclusive = false
    )
}
