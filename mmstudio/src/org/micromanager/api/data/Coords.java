package org.micromanager.api.data;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * The Coords class tracks the position of an image in the dataset.
 */
public interface Coords {
   
   /**
    * Given an axis label (for example "t" or "z" or "polarization"), returns
    * the position of this Coords along that axis. Returns -1 if this Coords
    * has no defined position along the axis; otherwise, values are assumed
    * to be non-negative integers. 
    */
   public int getPositionAt(String axis);

   /**
    * Set a position for the Coords along the specified axis. Overrides any
    * previous value for that axis.
    */
   public void setPosition(String axis, int value);

   /**
    * Returns true if this Coords marks the end of an axis of iteration in the
    * experiment, false otherwise. For example, if the experiment is collecting
    * Z-stacks with 10 images per stack, then any image with a value of Z=9
    * would return true when called with getIsAxisEndFor("z").
    * Note that a Coords being at the *beginning* of an axis is simply 
    * indicated by the position being 0 for that axis.
    */
   public boolean getIsAxisEndFor(String axis);

   /**
    * Marks this Coords as being at the end of an axis.
    */
   public void setIsAxisEndFor(String axis);

   /**
    * Returns a (possibly empty) set of all axes that this Coords is at the
    * end of.
    */
   public Set<String> getTerminalAxes();

   /**
    * Returns a list of all axes that this Coords has a position for.
    */
   public List<String> getAxes();

   /**
    * Generate a copy of this Coords, where each axis position is offset by
    * the corresponding value in the input HashMap. If the HashMap does not
    * have an entry for an axis, then that axis is left as-is; if the HashMap
    * has entries for axes that are not in this Coords, then those entries are
    * ignored.
    */
   public Coords makeOffsetCopy(HashMap<String, Integer> offsets);
}
