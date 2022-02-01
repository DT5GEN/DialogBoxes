package com.example.dialogboxes;

public class BadClass {

    private  int field1;
    private  int field2;
    private final int field3;
    private final int field4;
    private final int field5;

    public BadClass(int field1, int field2) {

        this(field1, field2, 0);

    }

    public BadClass(int field1, int field2, int field3) {
            this(field1, field2, field3, 0);
    }


    public BadClass(int field1, int field2, int field3, int field4) {

        this(field1, field2, field3, field4, 0);
    }

    public BadClass(int field1, int field2, int field3, int field4, int field5) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;

    }
}
