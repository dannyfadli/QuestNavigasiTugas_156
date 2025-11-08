package com.example.navigasi_tugas.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.navigasi_tugas.R

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

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.form_title)) }
            )
        }
    ) { pad ->
        Column(
            modifier = Modifier
                .padding(pad)
                .padding(horizontal = paddingMedium, vertical = paddingSmall)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Form fields
            Column(
                verticalArrangement = Arrangement.spacedBy(paddingSmall)
            ) {
                OutlinedTextField(
                    value = nama,
                    onValueChange = { nama = it },
                    label = { Text(stringResource(id = R.string.nama_lengkap)) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text = stringResource(id = R.string.jenis_kelamin),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium
                )

                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    RadioItem(label = "Laki-laki", selected = gender == "Laki-laki") { gender = "Laki-laki" }
                    RadioItem(label = "Perempuan", selected = gender == "Perempuan") { gender = "Perempuan" }
                }

                Text(
                    text = "STATUS PERKAWINAN",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium
                )

                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    RadioItem(label = "Janda", selected = status == "Janda") { status = "Jejaka" }
                    RadioItem(label = "Lajang", selected = status == "Lajang") { status = "Lajang" }
                    RadioItem(label = "Duda", selected = status == "Duda") { status = "Duda" }
                }

                OutlinedTextField(
                    value = alamat,
                    onValueChange = { alamat = it },
                    label = { Text(stringResource(id = R.string.alamat)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                )
            }

            // Buttons row
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = paddingSmall),
                horizontalArrangement = Arrangement.spacedBy(paddingSmall)
            ) {
                OutlinedButton(
                    onClick = { onBerandaClick() },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = stringResource(id = R.string.home))
                }

                Button(
                    onClick = {
                        // trigger submit and show dialog
                        onSubmit(nama.trim(), gender, status, alamat.trim())
                        showDialog = true
                    },
                    enabled = valid,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = stringResource(id = R.string.submit))
                }
            }
        }
    }

    if (showDialog) {
        Dialog(onDismissRequest = { /* prevent dismiss by outside touch if desired */ }) {
            // Use a subtle gradient background for dialog to make it stand out
            val cardShape = RoundedCornerShape(16.dp)
            Card(
                shape = cardShape,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .wrapContentHeight(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(modifier = Modifier.padding(paddingMedium)) {
                    Text(
                        text = stringResource(id = R.string.data_saved_title),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Dialog content rows
                    DialogRow(k = stringResource(id = R.string.nama_lengkap), v = nama)
                    Spacer(modifier = Modifier.height(8.dp))
                    DialogRow(k = stringResource(id = R.string.jenis_kelamin), v = gender)
                    Spacer(modifier = Modifier.height(8.dp))
                    DialogRow(k = "Status", v = status)
                    Spacer(modifier = Modifier.height(8.dp))
                    DialogRow(k = stringResource(id = R.string.alamat), v = alamat)

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        TextButton(onClick = {
                            showDialog = false
                            onSelesaiDialog()
                        }) {
                            Text(text = stringResource(id = R.string.ok))
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DialogRow(k: String, v: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = k)
        Text(text = v.ifBlank { "-" }, fontWeight = FontWeight.SemiBold)
    }
}

/**
 * Styled radio item with subtle selected color
 */
@Composable
private fun RadioItem(label: String, selected: Boolean, onSelect: () -> Unit) {
    val selectedColor = MaterialTheme.colorScheme.primary
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .padding(4.dp)
    ) {
        RadioButton(
            selected = selected,
            onClick = onSelect,
            colors = RadioButtonDefaults.colors(selectedColor = selectedColor)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = label, modifier = Modifier.padding(top = 2.dp))
    }
}