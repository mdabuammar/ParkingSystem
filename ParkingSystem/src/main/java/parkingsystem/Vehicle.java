
package parkingsystem;

abstract class Vehicle {
    private int id;
    private String type;
    private int duration;

    public Vehicle(int id, String type, int duration) {
        this.id = id;
        this.type = type;
        this.duration = duration;
    }

    public abstract int calculateParkingFee();

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    void setDuration(int parkingDuration) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}