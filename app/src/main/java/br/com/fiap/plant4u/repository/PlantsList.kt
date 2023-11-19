package br.com.fiap.plant4u.repository

import br.com.fiap.plant4u.R
import br.com.fiap.plant4u.model.Plant

fun getAllPlants(): List<Plant> {
    return listOf(
        Plant(
            id = 1,
            imageId = R.drawable.margarida,
            name = "Margarida",
            lastWatering = "ontem",
            frequency = "1 vez por semana",
            nextWatering = "24/09/2023",
            isError = true
        ),
        Plant(
            id = 2,
            imageId = R.drawable.cravo,
            name = "Cravo",
            lastWatering = "hoje, 10:00h",
            frequency = "a cada 3 dias",
            nextWatering = "21/09/2023",
            isError = false
        ),
        Plant(
            id = 3,
            imageId = R.drawable.lirio,
            name = "Lírio",
            lastWatering = "16/09/2023",
            frequency = "1 vez por semana",
            nextWatering = "23/09/2023",
            isError = false
        ),
        Plant(
            id = 4,
            imageId = R.drawable.hortela,
            name = "Hortelã",
            lastWatering = "ontem",
            frequency = "a cada 2 dias",
            nextWatering = "19/06/2023",
            isError = false
        ),
        Plant(
            id = 5,
            imageId = R.drawable.cacto,
            name = "Cacto",
            lastWatering = "14/09/2023",
            frequency = "1 vez por mês",
            nextWatering = "14/10/2023",
            isError = false
        ),
    )
}
