package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }
    @Test
    void whatsThisShouldBeUnknown() {
        Box box = new Box(3, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }


    @Test
    void getNumberOfVerticesShouldBeFour() {
        Box box = new Box(4, 10);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(4);
    }

    @Test
    void getNumberOfVerticesShouldBeMinusOne() {
        Box box = new Box(10, 5);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(-1);
    }

    @Test
    void isExistShouldBeTrue() {
        Box box = new Box(8, 10);
        boolean exists = box.isExist();
        assertThat(exists).isTrue();
    }

    @Test
    void isExistShouldBeFalseIfEdgeIsZero() {
        Box box = new Box(0, 0);
        boolean exists = box.isExist();
        assertThat(exists).isFalse();
    }

    @Test
    void isExistShouldBeFalseIfUnknown() {
        Box box = new Box(2, 10);
        boolean exists = box.isExist();
        assertThat(exists).isFalse();
    }


    @Test
    void getAreaShouldReturnSphereArea() {
        int edge = 5;
        Box box = new Box(0, edge);
        double expected = 4 * Math.PI * (edge * edge);
        assertThat(box.getArea()).isEqualTo(expected, withPrecision(0.01d));
    }

    @Test
    void getAreaShouldReturnCubeArea() {
        int edge = 3;
        Box box = new Box(8, edge);
        double expected = 6 * (edge * edge);
        assertThat(box.getArea()).isEqualTo(expected, withPrecision(0.01d));
    }

    @Test
    void getAreaShouldReturnZeroForUnknown() {
        Box box = new Box(5, 10);
        assertThat(box.getArea()).isEqualTo(0.0d);
    }
}
