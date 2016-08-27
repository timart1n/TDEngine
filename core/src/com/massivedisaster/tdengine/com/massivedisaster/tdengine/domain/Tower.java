package com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain;

/**
 * Created by sboychen on 27/08/2016.
 */
public class Tower extends Structure {
    private static final float [] UPDATE_COST = {100f, 125f, 160f, 200f, 300f};

    public Tower() {
        setName("Tower");
        setRange(10.0f);
        setLife(100.0f);
        setPower(5.0f);
        setLevel(0);
    }

    @Override
    public boolean updateLevel() {
        setLevel(getLevel() + 1);
        setPower(getPower() + (float) Math.log(getLevel()));
        return true;
    }
}
