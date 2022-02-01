package com.example.dialogboxes;

public class GoodClass {

    private int field1;
    private int field2;
    private final int field3;
    private final int field4;
    private final int field5;

    public GoodClass(int field1, int field2, int field3, int field4, int field5) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
    }

    public GoodClass(Builder builder) {
        field1 = builder.field1;
        field2 = builder.field2;
        field3 = builder.field3;
        field4 = builder.field4;
        field5 = builder.field5;
    }

    public static class Builder {
        private int field1;
        private int field2;
        private final int field3;
        private final int field4;
        private final int field5;


        public Builder setField1(int value) {
            field1 = value;
            return this;
        }

        public Builder setField2(int value) {
            field2 = value;
            return this;
        }

        public Builder(int field3, int field4, int field5) {
            this.field3 = field3;
            this.field4 = field4;
            this.field5 = field5;
        }
        public GoodClass build(){
            return new GoodClass(this);
        }
    }
}
