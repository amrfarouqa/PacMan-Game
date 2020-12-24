package amrfarouk.pacman;


import java.awt.*;


class EntityFactory {
    private static final Class[] BEHAVIORS
            = new Class[]{RoamingBehavior.class,
                          RandomBehavior.class,
                          GlancingBehavior.class};

    private static final Color[] COLORS
            = new Color[]{Color.RED, Color.GREEN, Color.YELLOW,
                          Color.CYAN, Color.PINK, Color.MAGENTA};


    public Creature createCreature() {
        return new Creature(new ControlledBehavior());
    }

    public Dot createDot() {
        return new Dot();
    }

    public RoamingDot createRoamingDot() {
        return new RoamingDot(createRandomBehavior(BEHAVIORS));
    }

    public Booster createBooster() {
        return new Booster();
    }

    public Dike createDike() {
        return new Dike(createRandomBehavior(BEHAVIORS));
    }

    public Fruit createFruit() {
        return new Fruit(Utilities.chooseElement(COLORS));
    }

    public Wall createWall() {
        return new Wall();
    }

    public Enemy createEnemy() {
        Color color = Utilities.chooseElement(COLORS);
        return new Enemy(createRandomBehavior(BEHAVIORS), color);
    }

    public Enemy createImmortalEnemy() {
        Color color = Utilities.chooseElement(COLORS);
        return new ImmortalEnemy(createRandomBehavior(BEHAVIORS), color);
    }

    public Enemy createSmartEnemy() {
        Color color = Utilities.chooseElement(COLORS);
        return new Enemy(new DirectedBehavior(), color);
    }

    private Behavior createRandomBehavior(Class[] behaviors) {
        try {
            Class behaviorClass = Utilities.chooseElement(behaviors);
            return (Behavior) behaviorClass.newInstance();
        } catch (InstantiationException
                e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException
                e) {
            throw new RuntimeException(e);
        }
    }
}
