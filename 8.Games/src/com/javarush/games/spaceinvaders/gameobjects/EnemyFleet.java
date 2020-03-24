package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length+1;
    private Direction direction = Direction.RIGHT;
    private List<EnemyShip> ships;

    public EnemyFleet(){
        createShips();
    }

    private void createShips(){
        ships = new ArrayList<EnemyShip>(ROWS_COUNT*COLUMNS_COUNT);
        for(int x = 0; x < COLUMNS_COUNT; x++){
            for (int y = 0; y < ROWS_COUNT; y++){
                ships.add(new EnemyShip(x * STEP, y * STEP + 12));
            }
        }
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 - 1, 5));
    }

    public void draw (Game game){
        for(int i = 0; i < ships.size(); i++){
            ships.get(i).draw(game);
        }
    }

    private double getLeftBorder(){
        double x_min = -1;
        for(EnemyShip ship : ships){
            if (x_min > ship.x || x_min == -1){
                x_min = ship.x;
            }
        }
        return x_min;
    }

    private double getRightBorder(){
        double x_max = -1;
        for(EnemyShip ship : ships){
            if (x_max < ship.x + ship.width || x_max == -1){
                x_max = ship.x + ship.width;
            }
        }
        return x_max;
    }

    private double getSpeed(){
        double max_speed = 2.0;
        return Math.min (max_speed, 3.0 / ships.size());
    }

    public double getBottomBorder(){
        double max_distance = -1;
        for(EnemyShip ship : ships){
            if (ship.y + ship.height > max_distance || max_distance == -1){
                max_distance = ship.y + ship.height;
            }
        }
        return max_distance;
    }

    public int getShipsCount(){
        return ships.size();
    }

    public void move(){
        if (ships.size() != 0){
            if (direction == Direction.LEFT && getLeftBorder() < 0){
                direction = Direction.RIGHT;
                for(EnemyShip ship : ships){
                    ship.move(Direction.DOWN, getSpeed());
                }
            }
            if (direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH){
                direction = Direction.LEFT;
                for(EnemyShip ship : ships){
                    ship.move(Direction.DOWN, getSpeed());
                }
            }
            for(EnemyShip ship : ships){
                ship.move(direction, getSpeed());
            }
        }
    }

    public Bullet fire (Game game){
        if (ships.isEmpty()) return null;
        if (game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY) > 0) {return null;}
        else{
            int index = game.getRandomNumber(ships.size());
            return ships.get(index).fire();
        }
    }

    public int verifyHit(List<Bullet> bullets){
        int score = 0;
        if(bullets.isEmpty()) return 0;
        if (ships.size() == 0) return 0;
        for(EnemyShip enemyShip : ships){
            for(Bullet bullet : bullets){
                if (enemyShip.isAlive && bullet.isAlive){
                    if(enemyShip.isCollision(bullet)){
                        bullet.kill();
                        enemyShip.kill();
                        score += enemyShip.score;
                    }
                }
            }
        }
        return score;
    }

    public void deleteHiddenShips(){
        Iterator<EnemyShip> enemyShipIterator = ships.iterator();
        while(enemyShipIterator.hasNext()){
            EnemyShip enemyShip = enemyShipIterator.next();
            if (!enemyShip.isVisible()){
                enemyShipIterator.remove();
            }
        }
    }

}
