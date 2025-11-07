package com.example.tugasnavigasi.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListPesertaScreen(
    nama: String,
    jenisKelamin: String,
    statusPerkawinan: String,
    alamat: String,
    onBerandaClick: () -> Unit,
    onFormulirClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0E9FF))
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "List Daftar Peserta",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(32.dp))

        InfoCard(label = "NAMA LENGKAP", value = nama)
        Spacer(modifier = Modifier.height(16.dp))

        InfoCard(label = "JENIS KELAMIN", value = jenisKelamin)
        Spacer(modifier = Modifier.height(16.dp))

        InfoCard(label = "STATUS PERKAWINAN", value = statusPerkawinan)
        Spacer(modifier = Modifier.height(16.dp))

        InfoCard(label = "ALAMAT", value = alamat)

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onBerandaClick,
            modifier = Modifier.fillMaxWidth().height(56.dp),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF673AB7))
        ) {
            Text(text = "Beranda", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onFormulirClick,
            modifier = Modifier.fillMaxWidth().height(56.dp),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD1C4E9),
                contentColor = Color(0xFF673AB7)
            )
        ) {
            Text(text = "Formulir Pendaftaran", fontSize = 16.sp)
        }
    }
}

