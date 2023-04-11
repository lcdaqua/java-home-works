package ru.qiwi.fortytwo;

public class FortyTwo extends Number implements Comparable<FortyTwo>, TheUltimateQuestionOfLifeTheUniverseAndEverything {

    private String value;

    public FortyTwo() {
        value = "42";
    }

    @Override
    public int intValue() {
        return Integer.parseInt(this.value);
    }

    @Override
    public long longValue() {
        return Long.parseLong(this.value);
    }

    @Override
    public float floatValue() {
        return Float.parseFloat(this.value);
    }

    @Override
    public double doubleValue() {
        return Double.parseDouble(this.value);
    }

    @Override
    public void getAnswer() {
        System.out.println(this.value);
    }

    @Override
    public int compareTo(FortyTwo o) {
        return value.compareTo(o.value);
    }
}
