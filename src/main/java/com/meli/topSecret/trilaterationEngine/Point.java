/*
 * This file is part of the Trilateration package.
 *
 *
 * Licensed under the MIT license:
 *   http://www.opensource.org/licenses/mit-license.php
 *
 *
 */
package com.meli.topSecret.trilaterationEngine;
public class Point{
private double lt,ln,r;
public Point(double lt,double ln,double r){this.lt=lt;this.ln=ln;this.r=r;}
public double glt(){return lt;}
public double gln(){return ln;}
public double gr(){return r;}
}