package org.barnsleyfern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BarnsleyFernTest {

    @Test
    void testApplyStem() {
        BarnsleyFern.FernCanvas fernCanvas = new BarnsleyFern.FernCanvas();
        double[] result = fernCanvas.applyStem(0.5, 0.8);
        assertEquals(0, result[0], 1e-9);
        assertEquals(0.16 * 0.8, result[1], 1e-9);
    }

    @Test
    void testApplyLeftLeaf() {
        BarnsleyFern.FernCanvas fernCanvas = new BarnsleyFern.FernCanvas();
        double[] result = fernCanvas.applyLeftLeaf(0.5, 0.8);
        assertEquals(0.2 * 0.5 - 0.26 * 0.8, result[0], 1e-9);
        assertEquals(0.23 * 0.5 + 0.22 * 0.8 + 1.6, result[1], 1e-9);
    }

    @Test
    void testApplyRightLeaf() {
        BarnsleyFern.FernCanvas fernCanvas = new BarnsleyFern.FernCanvas();
        double[] result = fernCanvas.applyRightLeaf(0.5, 0.8);
        assertEquals(-0.15 * 0.5 + 0.28 * 0.8, result[0], 1e-9);
        assertEquals(0.26 * 0.5 + 0.24 * 0.8 + 0.44, result[1], 1e-9);
    }

    @Test
    void testApplySuccessiveLeaf() {
        BarnsleyFern.FernCanvas fernCanvas = new BarnsleyFern.FernCanvas();
        double[] result = fernCanvas.applySuccessiveLeaf(0.5, 0.8);
        assertEquals(0.85 * 0.5 + 0.04 * 0.8, result[0], 1e-9);
        assertEquals(-0.04 * 0.5 + 0.85 * 0.8 + 1.6, result[1], 1e-9);
    }

}
