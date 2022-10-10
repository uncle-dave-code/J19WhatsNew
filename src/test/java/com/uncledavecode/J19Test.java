package com.uncledavecode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class J19Test {

    @Test
    void printRecord() {
        JEP405RecordPattern jep405RecordPattern = new JEP405RecordPattern();
        jep405RecordPattern.printRecord(new Person("Uncle Dave", 30, new Address("Main Street", "New York")));
    }

    @Test
    void printSwitchPatterns() {
        JEP427PatternMatchingSwitch jep427PatternMatchingSwitch = new JEP427PatternMatchingSwitch();
        jep427PatternMatchingSwitch.printSwitchPatterns(new Person("Uncle Dave", 30, new Address("Main Street", "New York")));
    }

    @Test
    void printSwitchGuards() {
        JEP427PatternMatchingSwitch jep427PatternMatchingSwitch = new JEP427PatternMatchingSwitch();
        jep427PatternMatchingSwitch.printSwitchGuards(new Person("Uncle Dave 30", 30, new Address("Main Street", "New York")));
        jep427PatternMatchingSwitch.printSwitchGuards(new Person("Uncle Dave 15", 15, new Address("Main Street", "New York")));
    }

}