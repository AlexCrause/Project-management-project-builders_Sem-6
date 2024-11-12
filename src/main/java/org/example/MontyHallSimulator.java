package org.example;

import java.util.HashMap;
import java.util.Random;

/**
 * В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла
 * (Парадокс Монти Холла — Википедия ) и наглядно убедиться в верности парадокса
 * (запустить игру в цикле на 1000 и вывести итоговый счет).
 * Необходимо:
 * Создать свой Java Maven или Gradle проект;
 * Подключить зависимость lombok.
 * Можно подумать о подключении какой-нибудь математической библиотеки для работы со статистикой
 * Самостоятельно реализовать прикладную задачу;
 * Сохранить результат в HashMap<шаг теста, результат>
 * Вывести на экран статистику по победам и поражениям
 *
 * Работы принимаются в виде ссылки на гит репозиторий со всеми ключевыми файлами проекта
 */
public class MontyHallSimulator {
    public static void main(String[] args) {
        HashMap<Integer, String> results = new HashMap<>();
        int wins = 0;
        int loses = 0;
        int simulations = 1000;

        for (int i = 0; i < simulations; i++) {
            MontyHallGame game = new MontyHallGame();
            game.setupGame();
            game.chooseDoor(new Random().nextInt(3)); // Случайный выбор игрока
            game.revealDoor(); // Открытие двери без приза
            game.switchDoor(); // Меняем выбор
            boolean win = game.isWin();
            results.put(i + 1, win ? "Победа" : "Поражение");
            if (win) {
                wins++;
            } else {
                loses++;
            }
        }

        // Вывод статистики
        System.out.println("Результаты: " + results);
        System.out.println("Количество побед: " + wins);
        System.out.println("Количество поражений: " + loses);
    }
}