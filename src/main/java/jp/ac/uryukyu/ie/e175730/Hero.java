package jp.ac.uryukyu.ie.e175730;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero extends LivingThing {

    public Hero (String name, int maximumHP, int attack) {
        super (name,maximumHP , attack);
    }
    @Override
    public void attack(LivingThing target) {
        int damage = (int) (Math.random() * getAttack());
        double prob = Math.random();
        if (prob < 0.4) {
            damage = (damage * 2);
            if (damage == 0) {
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), target.getName(), damage);
            } else if (getDead() != true){
                System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", getName(), target.getName(), damage);
                target.wounded(damage);
            }
        } else {
            if (damage == 0) {
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), target.getName(), damage);
            } else {
                if (getDead() != true) {
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), target.getName(), damage);
                    target.wounded(damage);
                }
            }
        }
    }

    /**
     * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */

    /**
     * Enemyへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param e 攻撃対象
     */

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        setHitPoint(getHitPoint() - damage);
        if (getHitPoint() <= 0) {
            setDead(true);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", getName());
        }
    }
}