package com.example.navigasi_tugas.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.dimensionResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    onSubmit: (String, String, String, String) -> Unit,
    onSelesaiDialog: () -> Unit,
    onBerandaClick: () -> Unit
) {
    // states
    var nama by rememberSaveable { mutableStateOf("") }
    var gender by rememberSaveable { mutableStateOf("") }
    var status by rememberSaveable { mutableStateOf("") }
    var alamat by rememberSaveable { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    // resources
    val paddingSmall = dimensionResource(id = R.dimen.padding_small)
    val paddingMedium = dimensionResource(id = R.dimen.padding_medium)
    val paddingLarge = dimensionResource(id = R.dimen.padding_large)
    val valid = nama.isNotBlank() && gender.isNotBlank() && status.isNotBlank() && alamat.isNotBlank()
