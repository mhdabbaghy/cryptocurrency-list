package com.mhd.cryptocurrencylist.presentation.coin_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.mhd.cryptocurrencylist.presentation.coin_detail.components.CoinTag
import com.mhd.cryptocurrencylist.presentation.coin_detail.components.TeamListItem

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState(initial = CoinDetailState(isLoading = true))

    Box(modifier = Modifier.fillMaxSize()) {

        state.coin?.let { coin ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier.weight(1f)
                        )

                        Text(
                            text = if (coin.isActive) "Active" else "Inactive",
                            color = if (coin.isActive) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = coin.description,
                        style = MaterialTheme.typography.body2
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Tags", style = MaterialTheme.typography.h3)
                    Spacer(modifier = Modifier.height(12.dp))
                    FlowRow(
                        mainAxisSpacing = 8.dp,
                        crossAxisSpacing = 8.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coin.tags.forEach { tag ->
                            CoinTag(tag = tag)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Team members", style = MaterialTheme.typography.h3)
                    Spacer(modifier = Modifier.height(12.dp))
                }

                items(coin.team) { teamMember ->
                    TeamListItem(
                        teamMember,
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                    Divider()
                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}

