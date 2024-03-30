package com.lab4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.lab4.UpgradeTriangle.Type.*;

import static org.junit.Assert.*;

public class UpgradeTriangleTest {

    @Test
    public void testClassifyInvalidTriangle() {
        assertEquals(UpgradeTriangle.Type.INVALID, UpgradeTriangle.classify(-1, 2, 3));
    }

    @Test
    public void testClassifyEquilateralTriangle() {
        assertEquals(UpgradeTriangle.Type.EQUILATERAL, UpgradeTriangle.classify(5, 5, 5));
    }

    @Test
    public void testClassifyIsoscelesTriangle() {
        assertEquals(UpgradeTriangle.Type.ISOSCELES, UpgradeTriangle.classify(5, 5, 6));
    }

    @Test
    public void testClassifyScaleneTriangle() {
        assertEquals(UpgradeTriangle.Type.SCALENE, UpgradeTriangle.classify(3, 4, 5));
    }

    @Test
    public void testClassifySideLengthZero() {
        assertEquals(UpgradeTriangle.Type.INVALID, UpgradeTriangle.classify(0, 4, 5));
    }

    @Test
    public void testClassifyMinimumValidSides() {
        assertEquals(UpgradeTriangle.Type.EQUILATERAL, UpgradeTriangle.classify(1, 1, 1));
    }

    @Test
    public void testClassifyMaximumValidSides() {
        assertEquals(UpgradeTriangle.Type.EQUILATERAL,
                UpgradeTriangle.classify(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void testClassifyDecisionCoverageScaleneTriangle() {
        assertEquals(UpgradeTriangle.Type.SCALENE, UpgradeTriangle.classify(4, 5, 6));
    }

    @Test
    public void testClassifyDecisionCoverageEquilateralTriangle() {
        assertEquals(UpgradeTriangle.Type.EQUILATERAL, UpgradeTriangle.classify(10, 10, 10));
    }

    @Test
    public void testClassifyDecisionCoverageIsoscelesTriangle() {
        assertEquals(UpgradeTriangle.Type.ISOSCELES, UpgradeTriangle.classify(7, 7, 10));
    }

    @Test
    public void testClassifyDecisionCoverageInvalidTriangle() {
        assertEquals(UpgradeTriangle.Type.INVALID, UpgradeTriangle.classify(2, 3, 10));
    }

    @Test
    public void testClassifySumOfTwoSidesEqualToThirdSide() {
        assertEquals(UpgradeTriangle.Type.INVALID, UpgradeTriangle.classify(2, 2, 4));
    }

    @Test
    public void testClassifySumOfTwoSidesLessThanThirdSide() {
        assertEquals(UpgradeTriangle.Type.INVALID, UpgradeTriangle.classify(3, 4, 7));
    }

    @Test
    public void testClassifyNegativeSideLength() {
        assertEquals(UpgradeTriangle.Type.INVALID, UpgradeTriangle.classify(-3, 4, 5));
    }

    @Test
    public void testClassifyLargeSideLengths() {
        assertEquals(UpgradeTriangle.Type.EQUILATERAL, UpgradeTriangle.classify(1000, 1000, 1000));
    }

    @Test
    public void test0() {
        assertEquals(UpgradeTriangle.classify(0, 0, 0), INVALID);
    }

    @Test
    public void test1() {
        assertEquals(UpgradeTriangle.classify(0, 1301, 1), INVALID);
    }

    @Test
    public void test2() {
        assertEquals(UpgradeTriangle.classify(1108, 1, 1), INVALID);
    }

    @Test
    public void test3() {
        assertEquals(UpgradeTriangle.classify(1, 0, -665), INVALID);
    }

    @Test
    public void test4() {
        assertEquals(UpgradeTriangle.classify(1, 1, 0), INVALID);
    }

    @Test
    public void test5() {
        assertEquals(UpgradeTriangle.classify(582, 582, 582), EQUILATERAL);
    }

    @Test
    public void test6() {
        assertEquals(UpgradeTriangle.classify(1, 1088, 15), INVALID);
    }

    @Test
    public void test7() {
        assertEquals(UpgradeTriangle.classify(1, 2, 450), INVALID);
    }

    @Test
    public void test8() {
        assertEquals(UpgradeTriangle.classify(1663, 1088, 823), SCALENE);
    }

    @Test
    public void test9() {
        assertEquals(UpgradeTriangle.classify(1187, 1146, 1), INVALID);
    }

    @Test
    public void test10() {
        assertEquals(UpgradeTriangle.classify(1640, 1640, 1956), ISOSCELES);
    }

    @Test
    public void test11() {
        assertEquals(UpgradeTriangle.classify(784, 784, 1956), INVALID);
    }

    @Test
    public void test12() {
        assertEquals(UpgradeTriangle.classify(1, 450, 1), INVALID);
    }

    @Test
    public void test13() {
        assertEquals(UpgradeTriangle.classify(1146, 1, 1146), ISOSCELES);
    }

    @Test
    public void test14() {
        assertEquals(UpgradeTriangle.classify(1640, 1956, 1956), ISOSCELES);
    }

    @Test
    public void test15() {
        assertEquals(UpgradeTriangle.classify(-1, 1, 1), INVALID);
    }

    @Test
    public void testCalculateAreaInvalidTriangle() {
        assertEquals(-1, UpgradeTriangle.calculateArea(-1, 2, 3), 0.001);
    }

    @Test
    public void testCalculateAreaEquilateralTriangle() {
        assertEquals(Math.sqrt(3) * 25 / 4, UpgradeTriangle.calculateArea(5, 5, 5), 0.001);
    }

    @Test
    public void testCalculateAreaIsoscelesTriangle() {
        assertEquals(Math.sqrt(20) * 4, UpgradeTriangle.calculateArea(6, 8, 6), 0.001);
    }

    @Test
    public void testCalculateAreaScaleneTriangle() {
        assertEquals(6, UpgradeTriangle.calculateArea(3, 4, 5), 0.001);
    }

    @Test
    public void testCalculateAreaSideLengthZero() {
        assertEquals(-1, UpgradeTriangle.calculateArea(0, 4, 5), 0.001);
    }

    @Test
    public void testCalculateAreaMinimumValidSides() {
        assertEquals(Math.sqrt(3) / 4, UpgradeTriangle.calculateArea(1, 1, 1), 0.001);
    }

    @Test
    public void testCalculateAreaMaximumValidSides() {
        assertEquals(Double.NaN, UpgradeTriangle.calculateArea(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE),
                0.001);
    }

    @Test
    public void testCalculateAreaDecisionCoverageScaleneTriangle() {
        assertEquals(6, UpgradeTriangle.calculateArea(3, 4, 5), 0.001);
    }

    @Test
    public void testCalculateAreaDecisionCoverageEquilateralTriangle() {
        assertEquals(Math.sqrt(3) * 100 * 100 / 4, UpgradeTriangle.calculateArea(100, 100, 100), 0.001);
    }

    @Test
    public void testCalculateAreaDecisionCoverageIsoscelesTriangle() {
        assertEquals(Math.sqrt(20) * 4, UpgradeTriangle.calculateArea(6, 8, 6), 0.001);
    }

    @Test
    public void testCalculateAreaDecisionCoverageInvalidTriangle() {
        assertEquals(-1, UpgradeTriangle.calculateArea(2, 3, 10), 0.001);
    }

    @Test
    public void testCalculateAreaSumOfTwoSidesEqualToThirdSide() {
        assertEquals(-1, UpgradeTriangle.calculateArea(2, 2, 4), 0.001);
    }

    @Test
    public void testCalculateAreaSumOfTwoSidesLessThanThirdSide() {
        assertEquals(-1, UpgradeTriangle.calculateArea(3, 4, 7), 0.001);
    }

    @Test
    public void testCalculateAreaNegativeSideLength() {
        assertEquals(-1, UpgradeTriangle.calculateArea(-3, 4, 5), 0.001);
    }

    @Test
    public void testCalculateAreaLargeSideLengths() {
        assertEquals(Math.sqrt(3) * 1000 * 1000 / 4, UpgradeTriangle.calculateArea(1000, 1000, 1000), 0.001);
    }

}
