
package parkingsystem;
class Bicycle extends Vehicle {
    public Bicycle(int id, int duration) {
        super(id, "Bicycle", duration);
    }

    @Override
    public int calculateParkingFee() {
        int fee = getDuration() * 20;
        return fee;
    }
}
