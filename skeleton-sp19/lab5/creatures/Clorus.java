package creatures;

import huglife.Action;
import huglife.Creature;
import huglife.Direction;
import huglife.Occupant;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import static huglife.HugLifeUtils.randomEntry;

public class Clorus extends Creature {

    /**
     * Creates a creature with the name N. The intention is that this
     * name should be shared between all creatures of the same type.
     *
     * @param n
     */
    private int r;
    private int g;
    private int b;

    public Clorus(double energy) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        this.energy = energy;
    }

    @Override
    public void move() {
        energy -= 0.03;
    }

    @Override
    public void attack(Creature c) {
        this.energy += c.energy();
    }

    @Override
    public Creature replicate() {
        energy *= 0.5;
        Clorus offSpring = new Clorus(energy);
        return offSpring;
    }

    @Override
    public void stay() {
        energy -= 0.01;
    }

    @Override
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        Deque<Direction> emptyDirection = new ArrayDeque<>();
        Deque<Direction> plips = new ArrayDeque<>();
        boolean anyPlip = false;

        for (Direction d: neighbors.keySet()) {
            if (neighbors.get(d).name().equals("empty")) {
                emptyDirection.add(d);
            } else if (neighbors.get(d).name().equals("plip")) {
                anyPlip = true;
                plips.add(d);
            }
        }

        if (emptyDirection.size() == 0) {
            return new Action(Action.ActionType.STAY);
        } else if (anyPlip) {
            return new Action(Action.ActionType.ATTACK, randomEntry(plips));
        } else if (energy >= 1) {
            return new Action(Action.ActionType.REPLICATE, randomEntry(emptyDirection));
        } else {
            return new Action(Action.ActionType.STAY);
        }
    }

    @Override
    public Color color() {
        r = 34;
        g = 0;
        b = 231;
        return new Color(r,g,b);
    }
}
