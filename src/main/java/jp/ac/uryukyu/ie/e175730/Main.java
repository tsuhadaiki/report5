package jp.ac.uryukyu.ie.e175730;

/**
 * Created by tnal on 2016/11/13.
 */
public class Main {
    public static void main(String[] args){
        Hero hero = new Hero("勇者", 10, 5);
        Enemy enemy = new Enemy("スライム", 6, 3);

        System.out.printf("%s vs. %s\n", hero.getName(), enemy.getName());

        int turn = 0;
        while( hero.isDead() == false && enemy.isDead() == false ){
            turn++;
            System.out.printf("%dターン目開始！\n", turn);
            if(enemy.getHitPoint() > 0 && hero.getHitPoint() > 0){
                hero.attack(enemy);
            }else{
                break;
            }
            if(enemy.getHitPoint() > 0 && hero.getHitPoint() > 0){
                enemy.attack(hero);
            }else{
                break;
            }
        }
        System.out.println("戦闘終了");
    }
}
