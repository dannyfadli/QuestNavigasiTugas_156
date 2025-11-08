package com.example.navigasi_tugas.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigasi_tugas.R


data class Participant(
    val nama: String,
    val jenisKelamin: String,
    val status: String,
    val alamat: String
)

@Composable
fun ListParticipant(
    onBerandaClick: () -> Unit,
    onFormulirClick: () -> Unit
) {
    val paddingMedium = dimensionResource(id = R.dimen.padding_medium)
    val paddingLarge = dimensionResource(id = R.dimen.padding_large)

    Scaffold(
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = onBerandaClick,
                        modifier = Modifier.weight(1f)
                    ) { Text("Beranda") }

                    OutlinedButton(
                        onClick = onFormulirClick,
                        modifier = Modifier.weight(1f)
                    ) { Text("Formulir") }
                }
            }
        }
    ) { innerPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = paddingMedium, vertical = paddingLarge)
            ) {
                Text(
                    text = "List Peserta",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = paddingMedium)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {

                    ElevatedCard(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(Modifier.padding(horizontal = 14.dp, vertical = 12.dp)) {
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Column(Modifier.weight(1f)) {
                                    Text(
                                        "NAMA LENGKAP",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                    Text(text = "nama", fontSize = 17.sp)
                                    Spacer(Modifier.height(8.dp))
                                    Text(
                                        "STATUS PERKAWINAN",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                    Text(text = "status", fontSize = 17.sp)
                                }
                                Column(Modifier.weight(1f)) {
                                    Text(
                                        "JENIS KELAMIN",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                    Text(text = "jenis kelamin", fontSize = 17.sp)
                                    Spacer(Modifier.height(8.dp))
                                    Text(
                                        "ALAMAT",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                    Text(text = "alamat", fontSize = 17.sp)
                                }
                            }
                        }
                    }
                    ElevatedCard(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(Modifier.padding(horizontal = 14.dp, vertical = 12.dp)) {
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Column(Modifier.weight(1f)) {
                                    Text(
                                        "NAMA LENGKAP",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                    Text(text = "nama", fontSize = 17.sp)
                                    Spacer(Modifier.height(8.dp))
                                    Text(
                                        "STATUS PERKAWINAN",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                    Text(text = "status", fontSize = 17.sp)
                                }
                                Column(Modifier.weight(1f)) {
                                    Text(
                                        "JENIS KELAMIN",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                    Text(text = "jenis kelamin", fontSize = 17.sp)
                                    Spacer(Modifier.height(8.dp))
                                    Text(
                                        "ALAMAT",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                    Text(text = "alamat", fontSize = 17.sp)
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}