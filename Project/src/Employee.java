

public abstract class Employee extends People {

    private Employee e;
    private Leader l;
    private double salary;
    private static boolean permission;

    public Employee(String name, int ID) {
        super(name, ID);
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public static boolean hasPermission() {
        return permission;
    }

    public void editPacket(EditPacketIF edit) {

    }

    public abstract boolean decision(int budget, String choice);
}
