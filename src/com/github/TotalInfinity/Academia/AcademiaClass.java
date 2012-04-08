package com.github.TotalInfinity.Academia;

import java.io.Serializable;

/**
 *
 * @author Ryan
 */
public abstract class AcademiaClass implements Serializable {
    long classExp;
    long expToLevel;
    public abstract void LevelUp();
}