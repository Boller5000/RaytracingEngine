package Trace.Math;

public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vector3D add(Vector3D v) {
        return new Vector3D(x + v.getX(), y + v.getY(), z + v.getZ());
    }

    public Vector3D subtract(Vector3D v) {
        return new Vector3D(x - v.getX(), y - v.getY(), z - v.getZ());
    }

    public double dotProduct(Vector3D v) {
        return x * v.getX() + y * v.getY() + z * v.getZ();
    }

    public Vector3D crossProduct(Vector3D v) {
        double crossX = y * v.getZ() - z * v.getY();
        double crossY = z * v.getX() - x * v.getZ();
        double crossZ = x * v.getY() - y * v.getX();
        return new Vector3D(crossX, crossY, crossZ);
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3D normalize() {
        double mag = magnitude();
        return new Vector3D(x / mag, y / mag, z / mag);
    }

    public Vector3D scale(double scalar) {
        return new Vector3D(x * scalar, y * scalar, z * scalar);
    }
}
