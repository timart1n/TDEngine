package com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain;

/**
 * Created by sboychen on 27/08/2016.
 */
public class World {

    private final int width;
    private final int height;

    private Structure [][] structures;
    private int [][] units;

    public World(int width, int height) {
        this.width = width;
        this.height = height;

        structures = new Structure[width][height];
        units = new int[width][height];
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

    public int[][] getUnits() {
        return units;
    }

    public Structure getStructures(int x, int y) {
        return structures[x][y];
    }

    public int getUnit(int x, int y) {
        return units[x][y];
    }

}
