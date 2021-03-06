package strategy.basic.object;

import strategy.basic.behavior.FlyByRocketBehavior;
import strategy.basic.behavior.QuackByLaughBehavior;

/**
 * Creator: Yao
 * Date:    2017/12/21
 * For:
 * Other:
 */
public class GreenDuck extends Duck {

    public GreenDuck() {
        this.quackBehavior = new QuackByLaughBehavior();
        this.flyBehavior = new FlyByRocketBehavior();
    }

    void display() {
        System.out.println("Green Duck");
    }
}