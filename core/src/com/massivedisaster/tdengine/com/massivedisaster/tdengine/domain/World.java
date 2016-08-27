package com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain;

import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain.hud.Hud;

public class World {

    private final int width;
    private final int height;
    private Structure [][] structures;

    private Unit [][] units;
    private boolean [][] isBuildingAllowed;

    private Hud hud;
    private SpriteBatch batch;
    private ResourceManager resourceManager;

    long lastTimeInMillis = 0;
    long timeInMillis = 0;

    public World(int width, int height) {
        this.width = width;
        this.height = height;

        structures = new Structure[width][height];
        units = new Unit[width][height];
        isBuildingAllowed = new boolean[width][height];
        resourceManager =  new ResourceManager(100, 5);
        batch = new SpriteBatch();
        hud = new Hud();
    }

    public void create() {
        hud.onCreate();
    }

    public void update() {
        timeInMillis = System.currentTimeMillis();
        resourceManager.update(this);
        lastTimeInMillis = timeInMillis;
    }

    public void render(SpriteBatch batch) {
        hud.render(batch, this);
    }

    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    public long getDeltaInMillis() {
        return 0 == lastTimeInMillis ? 0 : timeInMillis - lastTimeInMillis;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() { return width; }

    public Structure getStructures(int x, int y) {
        return structures[x][y];
    }

    public Structure[][] getStructures() {
        return structures;
    }

    public void addStructure(Structure structure, int x, int y) {
        structures[x][y] = structure;
    }

    public Unit[][] getUnits() {
        return units;
    }

    public Unit getUnit(int x, int y) {
        return units[x][y];
    }
}