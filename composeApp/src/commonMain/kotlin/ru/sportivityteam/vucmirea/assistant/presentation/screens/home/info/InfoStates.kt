package ru.sportivityteam.vucmirea.assistant.presentation.screens.home.info

import ru.sportivityteam.vucmirea.assistant.presentation.entity.InfoFutureItem
import ru.sportivityteam.vucmirea.assistant.presentation.entity.InfoItem

data class InfoViewState(
    val isLoading: Boolean = false,
    val items: List<InfoItem> = listOf(
        InfoItem(
            "Что такое Военный учебный центр при РТУ МИРЭА?",
            "Военный учебный центр (ВУЦ) — это структурное подразделение РТУ МИРЭА, которое предоставляет возможность пройти военную службу без отрыва от учебы и получить военно-учетную специальность.\n" +
                    "\n" +
                    "Военный учебный центр при РТУ МИРЭА имеет давнюю историю и традиции, являясь преемником военной кафедры МИРЭА, основанной в 1969 году. \n" +
                    "\n" +
                    "Студенты ВУЦ проходят обучение параллельно с занятиями в университете, а выпускники ВУЦ направляются на 30-дневные учебные сборы и после аттестации зачисляются в запас, с присвоением первого воинского звания и личного номера."
        ),
        InfoItem(
            "Военный учебный центр при РТУ МИРЭА проводит подготовку:",
            " - офицеров запаса по семи военно - учетным специальностям,\n" +
                    "\n" +
                    " - сержантов запаса по одной военно - учетной специальности,\n" +
                    "\n" +
                    " - солдат запаса по двум военно - учетным специальностям.\n" +
                    "\n" +
                    "Обучение в ВУЦ является добровольным, отбор кандидатов проводится на конкурсной основе. Студенты, не прошедшие обучение в ВУЦ, после окончания университета обязаны пройти военную службу по призыву или альтернативную гражданскую службу в соответствии с законодательством Российской Федерации.\n" +
                    "\n" +
                    "Миссия ВУЦ — укрепление оборонного потенциала России через создание квалифицированных военных кадров. Развитие интеллектуальных, физических и морально — волевых качеств студентов. Воспитание достойных граждан и патриотов.\n" +
                    "\n" +
                    "Ценности ВУЦ — патриотизм, стремление защищать народ и Отечество. Верность воинскому долгу и присяге. Коллективизм, готовность помочь товарищу в беде, честность, отзывчивость и взаимопомощь. Компетентность, постоянное совершенствование профессиональных навыков сотрудников и учащихся ВУЦ.\n" +
                    "\n" +
                    "Девиз ВУЦ — через знания к победе."
        )
    ),
    val futureItems: List<InfoFutureItem> = listOf()
)

sealed class InfoViewAction {
    data class OpenTelegram(val uri: String) : InfoViewAction()
    data class OpenPhoneNumber(val phoneNumber: String) : InfoViewAction()
    data class OpenAddress(val address: String) : InfoViewAction()
    data class OpenEmail(val email: String) : InfoViewAction()
}

sealed class InfoViewEvent {
    data class OpenTelegram(val uri: String) : InfoViewEvent()
    data class OpenPhoneNumber(val phoneNumber: String) : InfoViewEvent()
    data class OpenAddress(val address: String) : InfoViewEvent()
    data class OpenEmail(val email: String) : InfoViewEvent()
    data object Clear : InfoViewEvent()
}