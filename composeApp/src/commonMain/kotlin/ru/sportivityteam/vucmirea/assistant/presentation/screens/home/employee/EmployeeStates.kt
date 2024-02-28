package ru.sportivityteam.vucmirea.assistant.presentation.screens.home.employee

import ru.sportivityteam.vucmirea.assistant.presentation.entity.EmployeePresentation

data class EmployeeViewState(
    val isLoading: Boolean = false,
    val employeeList: List<EmployeePresentation> = listOf(
        EmployeePresentation(
            "https://vuc.mirea.ru/upload/medialibrary/737/7377cd49b93f954bea8491a8dcc6867a.jpg",
            "Каргапольцев Аркадий Аркадьевич",
            "Начальник Военного учебного центра, полковник запаса, кандидат военных наук, доцент",
            "kargapoltsev@mirea.ru",
            "+7(495)246-05-55",
            "доб. 601",
            "Аудитория 214",
            type = "ВКС"
        ),
        EmployeePresentation(
            "https://vuc.mirea.ru/upload/medialibrary/055/055021bbcd72a0498166b2738e4149fd.jpg",
            "Ситников Виктор Валерьевич",
            "Начальник учебной части - заместитель начальника Военного учебного центра, полковник",
            "sitnikov@mirea.ru",
            "+7(495)246-05-55",
            "доб. 602",
            "Аудитория 212",
            type = "ВКС"
        ),

        EmployeePresentation(
            "https://vuc.mirea.ru/upload/medialibrary/f1a/f1af74cff82b6386d61738372bd19dce.jpg",
            "Непорожнев Денис Александрович",
            "Начальник кафедры, полковник",
            "neporozhnev@mirea.ru",
            "+7(495)246-05-55",
            "доб. 612",
            "Аудитория 112",
            type = "ВКС"
        ),
        EmployeePresentation(
            "https://vuc.mirea.ru/upload/medialibrary/411/41175de9a7d75fb990cc78f9659601af.jpg",
            "Шубин Андрей Владимирович",
            "Доцент кафедры, подполковник запаса, кандидат военных наук",
            "shubin_a@mirea.ru",
            "+7(495)246-05-55",
            "доб. 606",
            "Аудитория 107",
            type = "ВКС"
        ),
        EmployeePresentation(
            "https://vuc.mirea.ru/upload/medialibrary/e77/e770c1309596d3849237e431e6ebab39.jpg",
            "Белоус Сергей Ильич",
            "Доцент кафедры, полковник запаса, кандидат военных наук",
            "belous@mirea.ru",
            "+7(495)246-05-55",
            "доб. 608",
            "Аудитория 108",
            type = "ВКС"
        ),
    )
)

sealed class EmployeeViewAction {

}

sealed class EmployeeViewEvent {

}