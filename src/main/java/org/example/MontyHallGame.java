package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class MontyHallGame {
    private boolean[] doors; // true - приз, false - ничего
    private int playerChoice;
    private int revealedDoor;
    //private boolean switchChoice;

    public void setupGame() {
        doors = new boolean[3];
        Random rand = new Random();
        doors[rand.nextInt(3)] = true; // Ставим приз за одной из дверей
    }

    public void chooseDoor(int choice) {
        playerChoice = choice;
    }

    public void revealDoor() {
        for (int i = 0; i < doors.length; i++) {
            if (doors[i] && i != playerChoice) { // Если это не выбранная дверь и там приз
                continue;
            }
            if (i != playerChoice) {
                revealedDoor = i; // Открывшаяся дверь
                break;
            }
        }
    }

    public void switchDoor() {
        for (int i = 0; i < doors.length; i++) {
            if (i != playerChoice && i != revealedDoor) {
                playerChoice = i; // Меняем выбор игрока
                break;
            }
        }
    }

    public boolean isWin() {
        return doors[playerChoice]; // Победа, если за выбранной дверью приз
    }
}
