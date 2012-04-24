//
// Pythagoras - a collection of geometry classes
// http://github.com/samskivert/pythagoras

package pythagoras.f;

import java.nio.FloatBuffer;

import pythagoras.util.Platform;

/**
 * Provides most of the implementation of {@link IVector3}, obtaining only x, y and z from the
 * derived class.
 */
public abstract class AbstractVector3 implements IVector3
{
    @Override // from interface IVector3
    public float dot (IVector3 other) {
        return x()*other.x() + y()*other.y() + z()*other.z();
    }

    @Override // from interface IVector3
    public Vector3 cross (IVector3 other) {
        return cross(other, new Vector3());
    }

    @Override // from interface IVector3
    public Vector3 cross (IVector3 other, Vector3 result) {
        float x = x(), y = y(), z = z();
        float ox = other.x(), oy = other.y(), oz = other.z();
        return result.set(y*oz - z*oy, z*ox - x*oz, x*oy - y*ox);
    }

    @Override // from interface IVector3
    public float triple (IVector3 b, IVector3 c) {
        float bx = b.x(), by = b.y(), bz = b.z();
        float cx = c.x(), cy = c.y(), cz = c.z();
        return x()*(by*cz - bz*cy) + y()*(bz*cx - bx*cz) + z()*(bx*cy - by*cx);
    }

    @Override // from interface IVector3
    public Vector3 negate () {
        return negate(new Vector3());
    }

    @Override // from interface IVector3
    public Vector3 negate (Vector3 result) {
        return result.set(-x(), -y(), -z());
    }

    @Override // from interface IVector3
    public Vector3 normalize () {
        return normalize(new Vector3());
    }

    @Override // from interface IVector3
    public Vector3 normalize (Vector3 result) {
        return mult(1f / length(), result);
    }

    @Override // from interface IVector3
    public float angle (IVector3 other) {
        return FloatMath.acos(dot(other) / (length() * other.length()));
    }

    @Override // from interface IVector3
    public float length () {
        return FloatMath.sqrt(lengthSquared());
    }

    @Override // from interface IVector3
    public float lengthSquared () {
        float x = x(), y = y(), z = z();
        return (x*x + y*y + z*z);
    }

    @Override // from interface IVector3
    public float distance (IVector3 other) {
        return FloatMath.sqrt(distanceSquared(other));
    }

    @Override // from interface IVector3
    public float distanceSquared (IVector3 other) {
        float dx = x() - other.x(), dy = y() - other.y(), dz = z() - other.z();
        return dx*dx + dy*dy + dz*dz;
    }

    @Override // from interface IVector3
    public float manhattanDistance (IVector3 other) {
        return Math.abs(x() - other.x()) + Math.abs(y() - other.y()) + Math.abs(z() - other.z());
    }

    @Override // from interface IVector3
    public Vector3 mult (float v) {
        return mult(v, new Vector3());
    }

    @Override // from interface IVector3
    public Vector3 mult (float v, Vector3 result) {
        return result.set(x()*v, y()*v, z()*v);
    }

    @Override // from interface IVector3
    public Vector3 mult (IVector3 other) {
        return mult(other, new Vector3());
    }

    @Override // from interface IVector3
    public Vector3 mult (IVector3 other, Vector3 result) {
        return result.set(x()*other.x(), y()*other.y(), z()*other.z());
    }

    @Override // from interface IVector3
    public Vector3 add (IVector3 other) {
        return add(other, new Vector3());
    }

    @Override // from interface IVector3
    public Vector3 add (IVector3 other, Vector3 result) {
        return add(other.x(), other.y(), other.z(), result);
    }

    @Override // from interface IVector3
    public Vector3 subtract (IVector3 other) {
        return subtract(other, new Vector3());
    }

    @Override // from interface IVector3
    public Vector3 subtract (IVector3 other, Vector3 result) {
        return add(-other.x(), -other.y(), -other.z(), result);
    }

    @Override // from interface IVector3
    public Vector3 add (float x, float y, float z) {
        return add(x, y, z, new Vector3());
    }

    @Override // from interface IVector3
    public Vector3 add (float x, float y, float z, Vector3 result) {
        return result.set(x() + x, y() + y, z() + z);
    }

    @Override // from interface IVector3
    public Vector3 addScaled (IVector3 other, float v) {
        return addScaled(other, v, new Vector3());
    }

    @Override // from interface IVector3
    public Vector3 addScaled (IVector3 other, float v, Vector3 result) {
        return result.set(x() + other.x()*v, y() + other.y()*v, z() + other.z()*v);
    }

    @Override // from interface IVector3
    public Vector3 lerp (IVector3 other, float t) {
        return lerp(other, t, new Vector3());
    }

    @Override // from interface IVector3
    public Vector3 lerp (IVector3 other, float t, Vector3 result) {
        float x = x(), y = y(), z = z();
        return result.set(x + t*(other.x() - x), y + t*(other.y() - y), z + t*(other.z() - z));
    }

    @Override // from interface IVector3
    public float get (int idx) {
        switch (idx) {
        case 0: return x();
        case 1: return y();
        case 2: return z();
        }
        throw new IndexOutOfBoundsException(String.valueOf(idx));
    }

    @Override // from interface IVector3
    public void get (float[] values) {
        values[0] = x();
        values[1] = y();
        values[2] = z();
    }

    @Override // from interface IVector3
    public FloatBuffer get (FloatBuffer buf) {
        return buf.put(x()).put(y()).put(z());
    }

    @Override
    public String toString () {
        return "[" + x() + ", " + y() + ", " + z() + "]";
    }

    @Override
    public int hashCode () {
        return Platform.hashCode(x()) ^ Platform.hashCode(y()) ^ Platform.hashCode(z());
    }

    @Override
    public boolean equals (Object other) {
        if (!(other instanceof AbstractVector3)) {
            return false;
        }
        AbstractVector3 ovec = (AbstractVector3)other;
        return (x() == ovec.x() && y() == ovec.y() && z() == ovec.z());
    }
}