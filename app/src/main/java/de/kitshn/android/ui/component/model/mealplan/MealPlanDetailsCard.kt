package de.kitshn.android.ui.component.model.mealplan

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.unit.dp
import de.kitshn.android.R
import de.kitshn.android.api.tandoor.model.TandoorMealPlan
import de.kitshn.android.ui.theme.Typography
import kotlin.math.roundToInt

@Composable
fun MealPlanDetailsCard(
    modifier: Modifier,
    mealPlan: TandoorMealPlan
) {
    if(mealPlan.title.isNotBlank() || !mealPlan.note.isNullOrBlank()) OutlinedCard(
        modifier = modifier
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            if(mealPlan.title.isNotBlank()) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .weight(1f, true),
                        text = mealPlan.title,
                        style = Typography.titleLarge
                    )

                    if(mealPlan.recipe == null) Text(
                        modifier = Modifier
                            .weight(1f, false)
                            .padding(top = 6.dp),
                        text = pluralStringResource(
                            R.plurals.common_plural_portion,
                            mealPlan.servings.roundToInt(),
                            mealPlan.servings.roundToInt()
                        ),
                        style = Typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                Spacer(Modifier.height(8.dp))
            }

            if(!mealPlan.note.isNullOrBlank()) Text(
                text = mealPlan.note ?: ""
            )
        }
    }
}