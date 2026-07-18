package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        ru.job4j.assertj.SimpleConvert simpleConvert = new ru.job4j.assertj.SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }
    @Test
    void checkList() {
        ru.job4j.assertj.SimpleConvert simpleConvert = new ru.job4j.assertj.SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .contains("three")
                .containsSequence("second", "three")
                .startsWith("first")
                .element(2).isEqualTo("three");

        assertThat(list).first().isEqualTo("first");
        assertThat(list).last().isNotNull().isEqualTo("five");
    }

    @Test
    void checkSet() {
        ru.job4j.assertj.SimpleConvert simpleConvert = new ru.job4j.assertj.SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "three", "five");
        assertThat(set).hasSize(4)
                .contains("first")
                .containsOnly("first", "second", "three", "five")
                .containsAnyOf("five", "six", "seven")
                .doesNotContain("four");
    }

    @Test
    void checkMap() {
        ru.job4j.assertj.SimpleConvert simpleConvert = new ru.job4j.assertj.SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three");
        assertThat(map).hasSize(3)
                .containsKeys("first", "three")
                .containsValues(0, 1, 2)
                .doesNotContainKey("four")
                .doesNotContainValue(5)
                .containsEntry("second", 1);

        assertThat(map).contains(entry("first", 0));
    }
}