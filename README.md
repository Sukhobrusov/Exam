# Exam
Бабуины и Капуцины
Level Loader - загрузчик уровня. Загружает он его из res/level.txt
Существует 3 класса - Бабуин, Капуцин и Пустая Клетка

* * - Бабуин,
* _ - Пустая Клетка
* @ - Капуцин

Сам проект написан через паттерн MVC.

* View - интерфейс,
* Controller - контроллер,
* Model - опционал.

В view - KeyHandler - это слушатель кнопок, наследуется от KeyAdapter

* КЛАВИШИ - 
* Q - Двинуться всем объектам влемо вверх,
* W - Всем вверх,
* E - Всем вправо вверх,
* Y - Перезагрузить уровень,
* Z - Всем влево вниз,
* X - Всем вниз,
* C - Всем вправо вниз,
* P - Ход в случайном напрвлении всех существ.
     
     
GameObject - это наш объект(капуцин,бабуин или пустая клетка, все эти классы унаследованы от него)
Capucin - Капуцин,
Baboon - Бабуин,
EmptyBoard - Пустая Клетка.

GameObjects - Выдает нам объекты по их координатам и наоборот, содержит все объекты.
