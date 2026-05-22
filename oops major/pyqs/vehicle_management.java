abstract class Vehicle
{
    protected String brand;
    protected int speed;

    Vehicle(String brand , int speed)
    {
        this.brand=brand;
        this.speed=speed;
    }

    abstract void accelerate(int increment);

    void displayInfo()
    {
        System.out.println(this.brand);
        System.out.println(this.speed);
    }
}
    interface Electric 
    {
        void chargeBattery();    
    }

    interface FuelBased
    {
        void refuel();
    }

    class ElectricCar extends Vehicle implements Electric
    {
        ElectricCar(String brand , int speed)
        {
            super(brand,speed);
        }
        public void chargeBattery()
        {
            System.out.println("Charging battery of ElectricCar");
        }

        void accelerate(int increment)
        {
            this.speed+=increment;
        }
    }

    class PetrolBike extends Vehicle implements FuelBased
    {
        PetrolBike(String brand , int speed)
        {
            super(brand,speed);
        }

        void accelerate(int increment)
        {
            this.speed+=increment;
        }

        public void refuel()
        {
            System.out.println("Refuelling PetrolBike");
        }
    }

public class vehicle_management 
{
    public static void main(String[] args)
    {
        Vehicle rk[]=new Vehicle[2];
        rk[0]=new ElectricCar("Tata", 90);
        rk[1]=new PetrolBike("Yamaha", 120);

        
        System.out.println("----- DISPLAYING BRAND AND SPEED BEFORE INCREMENT-----");
        for (int i = 0; i < rk.length; i++) 
        {
            System.out.println(rk[i].getClass().getSimpleName());
            rk[i].displayInfo();
            System.out.println();
        }

        rk[0].accelerate(10);
        rk[1].accelerate(15);
        

        System.out.println("----- DISPLAYING BRAND AND SPEED AFTER INCREMENT-----");
        for (int i = 0; i < rk.length; i++) 
        {
            System.out.println(rk[i].getClass().getSimpleName());
            rk[i].displayInfo();
            System.out.println();
        }
        System.out.println("DISPLAYING INTERFACE METHODS");
        ((ElectricCar)rk[0]).chargeBattery();
        ((PetrolBike)rk[1]).refuel();
    }
}
