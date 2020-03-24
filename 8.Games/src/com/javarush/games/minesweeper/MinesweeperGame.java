package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField = 0;
    private int countFlags = 0;
    private int countClosedTiles = SIDE*SIDE;
    private int score = 0;
    private boolean isGameStopped = false;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (!isGameStopped){
            openTile(x, y);
        }
        if (isGameStopped) {
            restart();
        }

    }

    @Override
    public void onMouseRightClick(int x, int y) { markTile(x, y); }

    private void createGame() {

        for (int y = 0; y < gameField.length; y++) {
            for (int x = 0; x < gameField[y].length; x++) {
                boolean isMine = (getRandomNumber(10) == 1) ? true : false;
                countMinesOnField = (isMine) ? ++countMinesOnField : countMinesOnField;
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
                setCellValue(x, y, "");
            }
        }


        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private void countMineNeighbors() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (!gameField[i][j].isMine) {
                    ArrayList<GameObject> gameObjects = getNeighbors(gameField[i][j]);
                    gameField[i][j].countMineNeighbors = 0;
                    for (GameObject gameObject : gameObjects) {
                        if (gameObject.isMine) {
                            gameField[i][j].countMineNeighbors++;
                        }
                    }
                }
            }
        }
    }

    private ArrayList<GameObject> getNeighbors(GameObject gameObject) {
        ArrayList<GameObject> gameObjects = new ArrayList<>();
        int x = gameObject.x;
        int y = gameObject.y;
        if (y > 0) {
            gameObjects.add(gameField[y - 1][x]);
            if (x > 0) gameObjects.add(gameField[y - 1][x - 1]);
            if (x < SIDE - 1) gameObjects.add(gameField[y - 1][x + 1]);
        }
        if (y < SIDE - 1) {
            gameObjects.add(gameField[y + 1][x]);
            if (x > 0) gameObjects.add(gameField[y + 1][x - 1]);
            if (x < SIDE - 1) gameObjects.add(gameField[y + 1][x + 1]);
        }
        if (x > 0) gameObjects.add(gameField[y][x - 1]);
        if (x < SIDE - 1) gameObjects.add(gameField[y][x + 1]);

        return gameObjects;
    }


    private void openTile(int x, int y) {
        GameObject gameObject = gameField[y][x];
        if (!gameObject.isOpen && !gameObject.isFlag && !isGameStopped) {
            gameObject.isOpen = true;
            if (gameObject.isMine) {
                setCellValueEx(x, y, Color.RED, MINE);
                gameOver();
            }
            if (!gameObject.isMine){
                setCellColor(x, y, Color.GREEN);
                score += 5;
                setScore(score);
                countClosedTiles--;
                if (countClosedTiles == countMinesOnField){
                    win();
                }
                if (gameObject.countMineNeighbors == 0) {
                    setCellValue(x, y, "");
                    List<GameObject> gameObjects = getNeighbors(gameObject);
                    for (GameObject neibgGameObject : gameObjects) {
                        if (!neibgGameObject.isOpen && !gameObject.isFlag && !gameObject.isMine) {
                            openTile(neibgGameObject.x, neibgGameObject.y);
                        }
                    }
                } else {
                    setCellNumber(x, y, gameObject.countMineNeighbors);
                }
            }
        }
    }

    private void markTile(int x, int y){
        GameObject gameObject = gameField[y][x];
        if (!gameObject.isOpen && countFlags > 0 && !isGameStopped){
            if (!gameObject.isFlag){
                gameObject.isFlag = true;
                countFlags--;
                setCellValue(x,y,FLAG);
                setCellColor(x,y,Color.OLIVE);
                return;
            }
            if (gameObject.isFlag){
                gameObject.isFlag = false;
                countFlags++;
                setCellValue(x,y,"");
                setCellColor(x,y,Color.ORANGE);
                return;
            }
        }
    }

    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.BLUE,"You lose",Color.YELLOWGREEN,40);
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.GOLD,"Congratulations!!! You win",Color.ORANGERED,40);
    }

    private void restart(){
        score = 0;
        setScore(score);
        countClosedTiles = SIDE*SIDE;
        countFlags = 0;
        countMinesOnField = 0;
        if (isGameStopped) {
            isGameStopped = false;
        }
        createGame();
    }
}


