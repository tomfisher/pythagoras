//
// Pythagoras - a collection of geometry classes
// http://github.com/samskivert/pythagoras

package pythagoras.f;

import java.nio.FloatBuffer;

/**
 * Provides read-only access to a {@link Plane}.
 */
public interface IPlane
{
    /** Returns the plane constant. */
    float constant ();

    /** Returns the plane normal. */
    IVector3 normal ();

    /**
     * Stores the contents of this plane into the specified buffer.
     */
    FloatBuffer get (FloatBuffer buf);

    /**
     * Computes and returns the signed distance from the plane to the specified point.
     */
    float distance (IVector3 pt);

    // /**
    //  * Transforms this plane by the specified transformation.
    //  *
    //  * @return a new plane containing the result.
    //  */
    // Plane transform (Transform transform);

    // /**
    //  * Transforms this plane by the specified transformation, placing the result in the object
    //  * provided.
    //  *
    //  * @return a reference to the result plane, for chaining.
    //  */
    // Plane transform (Transform transform, Plane result);

    /**
     * Negates this plane.
     *
     * @return a new plane containing the result.
     */
    Plane negate ();

    /**
     * Negates this plane, placing the result in the object provided.
     *
     * @return a reference to the result, for chaining.
     */
    Plane negate (Plane result);

    // /**
    //  * Computes the intersection of the supplied ray with this plane, placing the result
    //  * in the given vector (if the ray intersects).
    //  *
    //  * @return true if the ray intersects the plane (in which case the result will contain
    //  * the point of intersection), false if not.
    //  */
    // boolean intersection (Ray3D ray, Vector3 result);

    // /**
    //  * Computes the signed distance to this plane along the specified ray.
    //  *
    //  * @return the signed distance, or {@link Float#NaN} if the ray runs parallel to the plane.
    //  */
    // float distance (Ray3D ray);
}
