package ru.harry.Models;

public enum EventStatus {
    Create(1),//Создан
    Edit(2),//Редактирование
    Joined(3),//Присоединились
    Canceled(4),//Отменен
    Live(5),//Идет сейчас
    Completed(6)//Завершен
    ;

    EventStatus(int i) { }
}
