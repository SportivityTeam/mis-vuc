package ru.sportivityteam.vucmirea.assistant.home.info.ui

import ru.sportivityteam.vucmirea.assistant.MR
import ru.sportivityteam.vucmirea.assistant.home.schedule.domain.entity.InfoFutureItem
import ru.sportivityteam.vucmirea.assistant.core.uikit.mvi.BaseStateScreenModel

class InfoSM :
    BaseStateScreenModel<InfoViewState, InfoViewAction, InfoViewEvent>(initialState = InfoViewState()) {
    init {
        viewState = viewState.copy(
            futureItems = listOf(
                InfoFutureItem(
                    iconResId = MR.images.ic_address.drawableResId,
                    text = "Почтовый адрес: 119454 г. Москва, проспект Вернадского, 78, Военный учебный центр.",
                    onClickAction = { obtainEvent(InfoViewEvent.OpenAddress("http://maps.google.com/maps?saddr=55.728647,37.573097")) }
                ),
                InfoFutureItem(
                    iconResId = MR.images.ic_address.drawableResId,
                    text = "Адрес: 119048 г. Москва, улица Усачева, 7/1",
                    onClickAction = { obtainEvent(InfoViewEvent.OpenAddress("http://maps.google.com/maps?saddr=55.728647,37.573097")) }
                ),
                InfoFutureItem(
                    iconResId = MR.images.ic_phone.drawableResId,
                    text = "Дежурный: +7 (499) 600-86-03",
                    onClickAction = { obtainEvent(InfoViewEvent.OpenPhoneNumber("8 (499) 600-86-03")) }
                ),
                InfoFutureItem(
                    iconResId = MR.images.ic_phone.drawableResId,
                    text = "Учебная часть: +7 (495) 246-05-55 доб. 604",
                    onClickAction = { obtainEvent(InfoViewEvent.OpenPhoneNumber("8 (495) 246-05-55")) }
                ),
                InfoFutureItem(
                    iconResId = MR.images.ic_email.drawableResId,
                    text = "Email: vuc@mirea.ru",
                    onClickAction = { obtainEvent(InfoViewEvent.OpenEmail("vuc@mirea.ru")) }
                ),
                InfoFutureItem(
                    iconResId = MR.images.ic_telegram.drawableResId,
                    text = "Telegram: Новости",
                    onClickAction = { obtainEvent(InfoViewEvent.OpenTelegram("https://t.me/wutz_mirea")) }
                ),
                InfoFutureItem(
                    iconResId = MR.images.ic_telegram.drawableResId,
                    text = "Telegram: Бот",
                    onClickAction = { obtainEvent(InfoViewEvent.OpenTelegram("https://t.me/vuc_mirea_bot")) }
                ),
            )
        )
    }

    override fun obtainEvent(viewEvent: InfoViewEvent) {
        viewAction = when (viewEvent) {
            is InfoViewEvent.OpenTelegram -> InfoViewAction.OpenTelegram(viewEvent.uri)
            is InfoViewEvent.OpenAddress -> InfoViewAction.OpenAddress(viewEvent.address)

            is InfoViewEvent.OpenEmail -> InfoViewAction.OpenEmail(viewEvent.email)
            is InfoViewEvent.OpenPhoneNumber -> InfoViewAction.OpenPhoneNumber(viewEvent.phoneNumber)
            InfoViewEvent.Clear -> null
        }
    }
}