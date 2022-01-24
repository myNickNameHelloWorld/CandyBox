# language: ru
@all
Функционал: Ипотека

  @negative
  Сценарий: Проверка страницы калькулятора ипотеки
    * Загружена стартовая страница
    * Закрытие окна куки
    * Нажать на меню 'Ипотека'
    * Нажать на подменю 'Все ипотечные кредиты'
    * Кликнуть на заголовок 'Готовое жилье'
    * Проверка заголовка открывшейся страницы
    * Заполнение формы поле/значение
      | Стоимость недвижимости | 5180000 |
      | Первоначальный взнос   | 3058000 |
      | Срок кредита           | 30      |
    * Кликнуть по кнопке 'Страхование жизни'
    * Проверка поля 'Сумма кредита'
    * Проверка поля 'Ежемесячный платеж'
    * Проверка поля 'Необходимый доход'
    * Проверка поля 'Процентная ставка'
