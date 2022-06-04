package com.cv.lib.classTut;

abstract public class FileSystem{
    private int size;
    private final String name;
    protected String type;
    private final long createdTime;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public abstract void doWork(int a);
    public abstract void doWork(float a);
    public abstract void doWork(int a, String b);

    public FileSystem(int size, String name, String type, long createdTime){
        this.name = name;
        this.size = size;
        this.type = type;
        this.createdTime = createdTime;
        System.out.println("FileSystem is created");
    }

    protected void run(){
        System.out.println("FileSystem is running");
    }
    public abstract void copy();
    public abstract void move();
    public abstract void share();
    public abstract void rename(String name);

    final public void donate(int money){
        System.out.println("I am donating rupees: "+money);
        boolean isInLoss = money > 10000000;
        if (isInLoss) {
            sell(10000);
        }
    }

    private void sell(int price){
        System.out.println("I am going to sell in price: "+price);
    }
}

