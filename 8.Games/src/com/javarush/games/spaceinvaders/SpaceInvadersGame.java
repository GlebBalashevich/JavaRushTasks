package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.Bullet;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.PlayerShip;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int COMPLEXITY = 5;
    private static final int PLAYER_BULLETS_MAX = 3;
    private EnemyFleet enemyFleet;
    private PlayerShip playerShip;
    private List<Bullet> playerBullets;
    private List<Star> stars;
    private List<Bullet> enemyBullets;
    private boolean isGameStopped;
    private int animationsCount;
    private int score;

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        check();
        Bullet bullet = enemyFleet.fire(this);
        if (bullet != null) enemyBullets.add(bullet);
        setScore(score);
        drawScene();
    }

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void check() {
        if (enemyFleet.getBottomBorder() >= playerShip.y){
            playerShip.kill();
        }
        if (enemyFleet.getShipsCount() == 0){
            playerShip.win();
            stopGameWithDelay();
        }
        playerShip.verifyHit(enemyBullets);
        score += enemyFleet.verifyHit(playerBullets);
        enemyFleet.deleteHiddenShips();
        removeDeadBullets();
        if (!playerShip.isAlive) {
            stopGameWithDelay();
        }
    }

    private void createGame() {
        createStars();
        enemyFleet = new EnemyFleet();
        enemyBullets = new ArrayList<>();
        playerBullets = new ArrayList<>();
        playerShip = new PlayerShip();
        isGameStopped = false;
        animationsCount = 0;
        score = 0;
        setTurnTimer(40);
        drawScene();
    }

    private void drawScene() {
        drawField();
        playerShip.draw(this);
        enemyFleet.draw(this);
        for (Bullet bullet : enemyBullets) {
            bullet.draw(this);
        }
        for (Bullet bullet : playerBullets) {
            bullet.draw(this);
        }


    }

    private void drawField() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }

        for (int i = 0; i < stars.size(); i++) {
            stars.get(i).draw(this);
        }

    }

    private void createStars() {
        stars = new ArrayList<Star>(8);
        double x = 0;
        double y = 0;
        int width = WIDTH;
        int height = HEIGHT;
        for (int i = 0; i < 8; i++) {
            x = Math.random() * width;
            y = Math.random() * height;
            stars.add(new Star(x, y));
        }
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
        playerShip.move();
        for (Bullet bullet : enemyBullets) {
            bullet.move();
        }
        for (Bullet bullet : playerBullets) {
            bullet.move();
        }
    }

    private void removeDeadBullets() {
        Iterator<Bullet> bulletIterator = enemyBullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            if (!bullet.isAlive || bullet.y >= HEIGHT - 1) {
                bulletIterator.remove();
            }
        }

        Iterator<Bullet> playerbulletIterator = playerBullets.iterator();
        while (playerbulletIterator.hasNext()) {
            Bullet bullet = playerbulletIterator.next();
            if (!bullet.isAlive || bullet.y + bullet.height < 0) {
                playerbulletIterator.remove();
            }
        }
    }

    private void stopGame(boolean isWin) {
        isGameStopped = true;
        stopTurnTimer();
        if (isWin) {
            showMessageDialog(Color.AQUA, "Congratulations you have WON!!!", Color.GREEN, 14);
        } else {
            showMessageDialog(Color.AQUA, "Sorry, you LOST!!!", Color.RED, 14);
        }
    }

    private void stopGameWithDelay() {
        animationsCount++;
        if (animationsCount >= 10) {
            stopGame(playerShip.isAlive);
        }
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped && key == Key.SPACE) {
            createGame();
        }
        if (key == Key.LEFT) {
            playerShip.setDirection(Direction.LEFT);
        }
        if (key == Key.RIGHT) {
            playerShip.setDirection(Direction.RIGHT);
        }
        if (key == Key.SPACE) {
            Bullet playerBullet = playerShip.fire();
            if (playerBullet != null && playerBullets.size() < PLAYER_BULLETS_MAX) {
                playerBullets.add(playerBullet);
            }
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT && playerShip.getDirection() == Direction.LEFT) {
            playerShip.setDirection(Direction.UP);
        }
        if (key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT) {
            playerShip.setDirection(Direction.UP);
        }
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if (x >= 0 && x <= SpaceInvadersGame.WIDTH - 1) {
            if (y >= 0 && y <= SpaceInvadersGame.HEIGHT - 1) {
                super.setCellValueEx(x, y, cellColor, value);
            }
        }
    }
}
