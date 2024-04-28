
package parkingsystem;
class Car extends Vehicle {
    public Car(int id, int duration) {
        super(id, "Car", duration);
    }

    @Override
    public int calculateParkingFee() {
        int fee = getDuration() * 100;
      
        return fee;
    }
}