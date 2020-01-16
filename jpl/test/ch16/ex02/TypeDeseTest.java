package ch16.ex02;

import org.junit.Test;

import static org.junit.Assert.*;

public class TypeDeseTest {

    @Test
    public void main() {
        String[] str = {"java.util.HashMap"};
//        {"java.lang.Object"};
        TypeDese.main(str);
    }
}