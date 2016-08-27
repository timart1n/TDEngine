package com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain;

/**
 * Class responsible for managing all the available in game resources.
 */
public class ResourceManager implements UpdatableObject<World>{

    private double gold;
    private final float goldPerSecond;

    /**
     * Creates a ResourceManager
     * @param gold Initial quantity of gold available.
     * @param goldPerSecond Rate at which the gold increases per second.
     */
    public ResourceManager(int gold, float goldPerSecond) {
        this.gold = gold;
        this.goldPerSecond = goldPerSecond;
    }

    @Override
    public void update(World world) {
        gold += world.getDeltaInMillis() * goldPerSecond / 1000;
    }

    public double getGold() {
        return gold;
    }
}
