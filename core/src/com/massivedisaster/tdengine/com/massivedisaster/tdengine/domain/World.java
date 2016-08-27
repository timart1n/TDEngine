package com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain;

/**
 * Created by sboychen on 27/08/2016.
 */
public class World {

    private final int width;
    private final int height;

    private Structure [][] structures;
    private Unit [][] units;
    private boolean [][] isBuildingAllowed;

    public World(int width, int height) {
        this.width = width;
        this.height = height;

        structures = new Structure[width][height];
        units = new Unit[width][height];
        isBuildingAllowed = new boolean[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Structure[][] getStructures() {
        return structures;
    }

    public Unit[][] getUnits() {
        return units;
    }

    public Structure getStructures(int x, int y) {
        return structures[x][y];
    }

    public Unit getUnit(int x, int y) {
        return units[x][y];
    }

}
