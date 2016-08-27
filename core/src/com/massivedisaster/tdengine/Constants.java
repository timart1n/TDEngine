package com.massivedisaster.tdengine;

import com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain.Structure;
import com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain.StructureRenderer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sboychen on 27/08/2016.
 */
public class Constants {
    public static final int TILE_SIZE = 32;
    public static final Map<Class<? extends Structure>, StructureRenderer> structureRenderers = new HashMap<Class<? extends Structure>, StructureRenderer>();
    public static final int IDEAL_RESOLUTION_WIDTH = 1024;
    public static final int IDEAL_RESOLUTION_HEIGHT = 768;
}
