package com.example.weekbreakfast

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.weekbreakfast.breakfast_cards.BreakfastCard
import com.example.weekbreakfast.ui.theme.WeekBreakfastTheme

@Composable
fun BreakfastCardList(
    breakfastCardList: List<BreakfastCard>,
    contentPadding: PaddingValues = PaddingValues(dimensionResource(R.dimen.zeroPadding)),
) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }
    LazyColumn(contentPadding = contentPadding) {
        itemsIndexed(breakfastCardList) { index, breakfastCard ->
            BreakfastCard(breakfastCard = breakfastCard, index)
        }
    }
}

@Composable
fun BreakfastCard(
    breakfastCard: BreakfastCard, index: Int,
) {
    Card(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(dimensionResource(R.dimen.roundCorner)))
            .padding(dimensionResource(R.dimen.regularPadding))
    )
    {
        Column(
            Modifier
                .padding(dimensionResource(id = R.dimen.regularPadding))
        ) {
            Text(
                text = "День $index",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = stringResource(id = breakfastCard.breakfastNameRes),
                style = MaterialTheme.typography.displayMedium
            )
            Image(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(dimensionResource(R.dimen.roundCorner))),
                painter = painterResource(breakfastCard.breakfastImageRes),
                contentDescription = stringResource(id = breakfastCard.breakfastNameRes),
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = stringResource(id = breakfastCard.breakfastDescriptionRes),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun BreakfastCardPreview() {
//    val breakfastCard = BreakfastCard(
//        R.string.breakfast1,
//        R.string.breakfast_description1,
//        R.drawable.breakfast_img1
//    )
//    WeekBreakfastTheme {
//        BreakfastCard(breakfastCard = breakfastCard, 12)
//    }
//}

@Preview(showBackground = true)
@Composable
fun BreakfastCardListPreview() {
    val breakfastCards = com.example.weekbreakfast.breakfast_cards.BreakfastCardList.cards

    WeekBreakfastTheme {
        BreakfastCardList(breakfastCardList = breakfastCards)
    }
}