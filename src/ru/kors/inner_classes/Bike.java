package ru.kors.inner_classes;

public class Bike {
    private Wheel front;
    private Wheel back;

    public void getInfo() {
        System.out.printf("The bike has a %s front wheel and a %s back wheel%n",
                front.getColor(), back.getColor());
    }
    public void setFront(Wheel front) {
        this.front = front;
    }

    public void setBack(Wheel back) {
        this.back = back;
    }

    public class Wheel {
        private String color;

        public String getColor() {
            return color;
        }

        public Wheel(String color) {
            this.color = color;
        }
    }
}
