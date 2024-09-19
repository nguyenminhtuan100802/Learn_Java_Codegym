package Codegym;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PhanLoaiTamGiacTest {
    @Test
    public void PhanLoaiTamGiac0() {
        int a = 1;
        int b = 1;
        int c = 2;
        String expected = "tam giác đều";
        String result = PhanLoaiTamGiac.PhanLoaiTamGiac(a, b, c);
        assertEquals(expected, result);
    }

}
