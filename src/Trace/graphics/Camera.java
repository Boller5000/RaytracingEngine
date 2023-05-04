package Trace.graphics;
import Trace.Math.Vector3D;

public class Camera {
    private Vector3D position;
    private Vector3D rotation;
    private double fov;
    private double aspectRatio;

    public Camera(Vector3D position, Vector3D rotation, double fov, double aspectRatio) {
        this.position = position;
        this.rotation = rotation;
        this.fov = fov;
        this.aspectRatio = aspectRatio;
    }

    public Ray getRayForPixel(int x, int y, int screenWidth, int screenHeight) {
        double halfWidth = screenWidth / 2.0;
        double halfHeight = screenHeight / 2.0;

        double fovRadians = Math.toRadians(fov);
        double aspectRatioScale = Math.tan(fovRadians / 2.0);

        double normalizedX = (x - halfWidth) / halfWidth;
        double normalizedY = (halfHeight - y) / halfHeight;

        double horizontalOffset = normalizedX * aspectRatioScale;
        double verticalOffset = normalizedY * aspectRatioScale;

        Vector3D forward = new Vector3D(0, 0, 1);
        Vector3D right = forward.crossProduct(rotation).normalize();
        Vector3D up = right.crossProduct(forward).normalize();

        Vector3D rayDirection = rotation
                .add(right.scale(horizontalOffset))
                .add(up.scale(verticalOffset))
                .normalize();

        return new Ray(position, rayDirection);
    }
}