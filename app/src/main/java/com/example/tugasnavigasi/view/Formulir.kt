package com.example.tugasnavigasi.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormulirPendaftaranScreen(
    onSubmitClick: (String, String, String, String) -> Unit
) {
    val namaLengkap = remember { mutableStateOf("") }
    val alamat = remember { mutableStateOf("") }

    val jenisKelaminOptions = listOf("Laki-laki", "Perempuan")
    val (selectedJk, onJkSelected) = remember { mutableStateOf(jenisKelaminOptions[1]) }

    val statusOptions = listOf("Janda", "Lajang", "Duda")
    val (selectedStatus, onStatusSelected) = remember { mutableStateOf(statusOptions[1]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0E9FF))
            .padding(horizontal = 24.dp, vertical = 32.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Formulir Pendaftaran",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 32.dp)
        )

        Text(text = "NAMA LENGKAP", fontSize = 14.sp, color = Color.DarkGray)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = namaLengkap.value,
            onValueChange = { namaLengkap.value = it },
            placeholder = { Text("Isian nama lengkap") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color(0xFF673AB7),
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color(0xFF673AB7)
            )
        )
        Spacer(modifier = Modifier.height(24.dp))

        RadioGroupSection(
            title = "JENIS KELAMIN",
            options = jenisKelaminOptions,
            selectedOption = selectedJk,
            onOptionSelected = onJkSelected
        )
        Spacer(modifier = Modifier.height(24.dp))

        RadioGroupSection(
            title = "STATUS PERKAWINAN",
            options = statusOptions,
            selectedOption = selectedStatus,
            onOptionSelected = onStatusSelected
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "ALAMAT", fontSize = 14.sp, color = Color.DarkGray)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = alamat.value,
            onValueChange = { alamat.value = it },
            placeholder = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color(0xFF673AB7),
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color(0xFF673AB7)
            )
        )

        Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                onSubmitClick(namaLengkap.value, selectedJk, selectedStatus, alamat.value)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF673AB7))
        ) {
            Text(text = "Submit", fontSize = 16.sp)
        }
    }
}

@Composable
fun RadioGroupSection(
    title: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Column {
        Text(text = title, fontSize = 14.sp, color = Color.DarkGray)
        Spacer(modifier = Modifier.height(8.dp))
        options.forEach { optionText ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .selectable(
                        selected = (optionText == selectedOption),
                        onClick = { onOptionSelected(optionText) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (optionText == selectedOption),
                    onClick = null, // onClick dihandle oleh Row
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color(0xFF673AB7)
                    )
                )
                Text(
                    text = optionText,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun FormulirPendaftaranScreenPreview() {
    FormulirPendaftaranScreen(onSubmitClick = { _, _, _, _ -> })
}
