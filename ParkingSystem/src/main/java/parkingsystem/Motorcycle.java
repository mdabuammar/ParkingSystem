
package parkingsystem;
class Motorcycle extends Vehicle {
    public Motorcycle(int id, int duration) {
        super(id, "Motorcycle", duration);
    }

    @Override
    public int calculateParkingFee() {
        int fee = getDuration() * 50;
     
        return fee;
    }
}