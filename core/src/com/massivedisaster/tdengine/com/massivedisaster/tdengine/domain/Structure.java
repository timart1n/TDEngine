package com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain;

/**
 * Created by sboychen on 27/08/2016.
 */
public class Structure {

    private int id;
    private String name;
    private float buildProgress;
    private float range;
    private float power;
    private float level;
    private float life;
    private boolean isAlly;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBuildProgress() {
        return buildProgress;
    }

    public void setBuildProgress(float buildProgress) {
        this.buildProgress = buildProgress;
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }

    public boolean isAlly() {
        return isAlly;
    }

    public void setAlly(boolean ally) {
        isAlly = ally;
    }

    public float getLife() {
        return life;
    }

    public void setLife(float life) {
        this.life = life;
    }
}
