Feature: Login Page

  @login
  Scenario: Проверка логина
    Given Пользователь открывает браузер
    Then Нажимает кнопку Login


  @login1
  Scenario: Проверка не успешного логина
    Given Пользователь открывает браузер
    Then Нажимает кнопку Login

