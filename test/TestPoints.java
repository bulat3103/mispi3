import com.bebra.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import static org.junit.Assert.*;

public class TestPoints {
    private PointResultController controller;

    @Before
    public void create() {
        controller = new PointResultController();
    }

    @After
    public void resetPoint() {
        controller = null;
    }

    @Test
    public void topLeft() {
        double r = 2;
        for (double x = -5; x < 0; x += 0.01) {
            for (double y = 0.01; y < 3; y += 0.01) {
                PointResult pointResult = controller.createPointResult(x, y, r);
                assertEquals(pointResult.toString(), "PointResult{" + "x=" + x + ", y=" + y + ", r=" + r + ", hit=" + "false" + "}");
            }
        }
    }

    @Test
    public void downLeftInsideArea() {
        double r = 3;
        for (double x = -3; x <= 0; x += 0.01) {
            for (double y = -3; y <= 0; y += 0.01) {
                PointResult pointResult = controller.createPointResult(x, y, r);
                assertEquals(pointResult.toString(), "PointResult{" + "x=" + x + ", y=" + y + ", r=" + r + ", hit=" + "true" + "}");
            }
        }
    }

    @Test
    public void downLeftOutsideArea() {
        double r = 3;
        for (double x = -5; x < -3; x += 0.01) {
            for (double y = -3; y <= 0; y += 0.01) {
                PointResult pointResult = controller.createPointResult(x, y, r);
                assertEquals(pointResult.toString(), "PointResult{" + "x=" + x + ", y=" + y + ", r=" + r + ", hit=" + "false" + "}");
            }
        }
    }

    @Test
    public void downRight() {
        double r = 2;
        for (double x = 0; x <= 3; x += 0.01) {
            for (double y = -3; y <= 0; y += 0.01) {
                if (y >= x / 2 - r / 2) {
                    PointResult pointResult = controller.createPointResult(x, y, r);
                    assertEquals(pointResult.toString(), "PointResult{" + "x=" + x + ", y=" + y + ", r=" + r + ", hit=" + "true" + "}");
                }
            }
        }
    }

    @Test
    public void topRight() {
        double r = 3;
        for (double x = 0; x <= 3; x += 0.01) {
            for (double y = 0; y <= 3; y += 0.01) {
                if (x * x + y * y <= 9) {
                    PointResult pointResult = controller.createPointResult(x, y, r);
                    assertEquals(pointResult.toString(), "PointResult{" + "x=" + x + ", y=" + y + ", r=" + r + ", hit=" + "true" + "}");
                }
            }
        }
    }

    @Test
    public void borders() {
        PointResult pointResult = controller.createPointResult(0, 3, 3);
        assertEquals(pointResult.toString(), "PointResult{" + "x=" + (double) 0 + ", y=" + (double) 3 + ", r=" + (double) 3 + ", hit=" + "true" + "}");

        pointResult = controller.createPointResult(0, -3, 3);
        assertEquals(pointResult.toString(), "PointResult{" + "x=" + (double) 0 + ", y=" + (double) -3 + ", r=" + (double) 3 + ", hit=" + "true" + "}");

        pointResult = controller.createPointResult(3, 0, 3);
        assertEquals(pointResult.toString(), "PointResult{" + "x=" + (double) 3 + ", y=" + (double) 0 + ", r=" + (double) 3 + ", hit=" + "true" + "}");

        pointResult = controller.createPointResult(-3, 0, 3);
        assertEquals(pointResult.toString(), "PointResult{" + "x=" + (double) -3 + ", y=" + (double) 0 + ", r=" + (double) 3 + ", hit=" + "true" + "}");
    }

    @Test(expected = NullPointerException.class)
    public void nullRInPoint() {
        PointResult pointResult = controller.createPointResult(0, 3, -1);
    }

    @Test(expected = NullPointerException.class)
    public void nullInPoint() {
        PointResult pointResult = controller.createPointResult(0, 3, 0);
    }
}