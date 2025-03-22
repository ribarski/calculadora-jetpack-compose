package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraApp()
        }
    }
}
@Composable
fun CalculadoraApp() {
    var displayValue by remember { mutableStateOf("0") }
    var operacao by remember { mutableStateOf("") }
    var primeiroNumero by remember { mutableStateOf("") }
    var novaOperacao by remember { mutableStateOf(false) }

    // Cores personalizadas para a calculadora
    val corFundo = Color(0xFF121212)
    val corBotaoNumerico = Color(0xFF2C2C2C)
    val corBotaoOperacao = Color(0xFFFF9800)
    val corBotaoAC = Color(0xFFD32F2F)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(corFundo)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 24.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Text(
                text = displayValue,
                fontSize = 64.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.End,
                maxLines = 1
            )
        }


        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CalcButton(
                    texto = "AC",
                    corFundo = corBotaoAC,
                    modifier = Modifier.weight(1f)
                ) {
                    displayValue = "0"
                    operacao = ""
                    primeiroNumero = ""
                    novaOperacao = false
                }

                CalcButton(
                    texto = "+/-",
                    corFundo = corBotaoNumerico,
                    modifier = Modifier.weight(1f)
                ) {
                    if (displayValue != "0") {
                        displayValue = if (displayValue.startsWith("-")) {
                            displayValue.substring(1)
                        } else {
                            "-$displayValue"
                        }
                    }
                }

                CalcButton(
                    texto = "%",
                    corFundo = corBotaoNumerico,
                    modifier = Modifier.weight(1f)
                ) {
                    val valor = displayValue.toDoubleOrNull()
                    if (valor != null) {
                        displayValue = (valor / 100).toString()
                    }
                }

                CalcButton(
                    texto = "÷",
                    corFundo = corBotaoOperacao,
                    modifier = Modifier.weight(1f)
                ) {
                    operacaoClicada("/", displayValue)
                    operacao = "/"
                    primeiroNumero = displayValue
                    novaOperacao = true
                }
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CalcButton(
                    texto = "7",
                    corFundo = corBotaoNumerico,
                    modifier = Modifier.weight(1f)
                ) {
                    numeroClicado("7", displayValue, novaOperacao)
                    if (novaOperacao) {
                        displayValue = "7"
                        novaOperacao = false
                    } else {
                        displayValue = if (displayValue == "0") "7" else displayValue + "7"
                    }
                }

                CalcButton(
                    texto = "8",
                    corFundo = corBotaoNumerico,
                    modifier = Modifier.weight(1f)
                ) {
                    if (novaOperacao) {
                        displayValue = "8"
                        novaOperacao = false
                    } else {
                        displayValue = if (displayValue == "0") "8" else displayValue + "8"
                    }
                }

                CalcButton(
                    texto = "9",
                    corFundo = corBotaoNumerico,
                    modifier = Modifier.weight(1f)
                ) {
                    if (novaOperacao) {
                        displayValue = "9"
                        novaOperacao = false
                    } else {
                        displayValue = if (displayValue == "0") "9" else displayValue + "9"
                    }
                }

                CalcButton(
                    texto = "×",
                    corFundo = corBotaoOperacao,
                    modifier = Modifier.weight(1f)
                ) {
                    operacao = "*"
                    primeiroNumero = displayValue
                    novaOperacao = true
                }
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CalcButton(
                    texto = "4",
                    corFundo = corBotaoNumerico,
                    modifier = Modifier.weight(1f)
                ) {
                    if (novaOperacao) {
                        displayValue = "4"
                        novaOperacao = false
                    } else {
                        displayValue = if (displayValue == "0") "4" else displayValue + "4"
                    }
                }

                CalcButton(
                    texto = "5",
                    corFundo = corBotaoNumerico,
                    modifier = Modifier.weight(1f)
                ) {
                    if (novaOperacao) {
                        displayValue = "5"
                        novaOperacao = false
                    } else {
                        displayValue = if (displayValue == "0") "5" else displayValue + "5"
                    }
                }

                CalcButton(
                    texto = "6",
                    corFundo = corBotaoNumerico,
                    modifier = Modifier.weight(1f)
                ) {
                    if (novaOperacao) {
                        displayValue = "6"
                        novaOperacao = false
                    } else {
                        displayValue = if (displayValue == "0") "6" else displayValue + "6"
                    }
                }

                CalcButton(
                    texto = "-",
                    corFundo = corBotaoOperacao,
                    modifier = Modifier.weight(1f)
                ) {
                    operacao = "-"
                    primeiroNumero = displayValue
                    novaOperacao = true
                }
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CalcButton(
                    texto = "1",
                    corFundo = corBotaoNumerico,
                    modifier = Modifier.weight(1f)
                ) {
                    if (novaOperacao) {
                        displayValue = "1"
                        novaOperacao = false
                    } else {
                        displayValue = if (displayValue == "0") "1" else displayValue + "1"
                    }
                }

                CalcButton(
                    texto = "2",
                    corFundo = corBotaoNumerico,
                    modifier = Modifier.weight(1f)
                ) {
                    if (novaOperacao) {
                        displayValue = "2"
                        novaOperacao = false
                    } else {
                        displayValue = if (displayValue == "0") "2" else displayValue + "2"
                    }
                }

                CalcButton(
                    texto = "3",
                    corFundo = corBotaoNumerico,
                    modifier = Modifier.weight(1f)
                ) {
                    if (novaOperacao) {
                        displayValue = "3"
                        novaOperacao = false
                    } else {
                        displayValue = if (displayValue == "0") "3" else displayValue + "3"
                    }
                }

                CalcButton(
                    texto = "+",
                    corFundo = corBotaoOperacao,
                    modifier = Modifier.weight(1f)
                ) {
                    operacao = "+"
                    primeiroNumero = displayValue
                    novaOperacao = true
                }
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CalcButton(
                    texto = "0",
                    corFundo = corBotaoNumerico,
                    modifier = Modifier.weight(2f)
                ) {
                    if (novaOperacao) {
                        displayValue = "0"
                        novaOperacao = false
                    } else {
                        displayValue = if (displayValue == "0") "0" else displayValue + "0"
                    }
                }

                CalcButton(
                    texto = ",",
                    corFundo = corBotaoNumerico,
                    modifier = Modifier.weight(1f)
                ) {
                    if (!displayValue.contains(".")) {
                        displayValue = if (novaOperacao) {
                            novaOperacao = false
                            "0."
                        } else {
                            "$displayValue."
                        }
                    }
                }

                CalcButton(
                    texto = "=",
                    corFundo = corBotaoOperacao,
                    modifier = Modifier.weight(1f)
                ) {
                    if (operacao.isNotEmpty() && primeiroNumero.isNotEmpty()) {
                        val valor1 = primeiroNumero.toDoubleOrNull() ?: 0.0
                        val valor2 = displayValue.toDoubleOrNull() ?: 0.0

                        val resultado = when (operacao) {
                            "+" -> valor1 + valor2
                            "-" -> valor1 - valor2
                            "*" -> valor1 * valor2
                            "/" -> if (valor2 != 0.0) valor1 / valor2 else Double.POSITIVE_INFINITY
                            else -> valor2
                        }

                        displayValue = if (resultado == resultado.toLong().toDouble()) {
                            resultado.toLong().toString()
                        } else {
                            resultado.toString()
                        }

                        operacao = ""
                        primeiroNumero = ""
                        novaOperacao = true
                    }
                }
            }
        }
    }
}

@Composable
fun CalcButton(
    texto: String,
    corFundo: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .aspectRatio(1f)
            .fillMaxWidth(),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = corFundo,
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = texto,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


fun numeroClicado(numero: String, displayValue: String, novaOperacao: Boolean): Pair<String, Boolean> {
    return if (novaOperacao) {
        Pair(numero, false)
    } else {
        Pair(if (displayValue == "0") numero else displayValue + numero, false)
    }
}

fun operacaoClicada(op: String, displayValue: String): Pair<String, String> {
    return Pair(op, displayValue)
}