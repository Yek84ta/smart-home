package devices;

public abstract class Device {
    protected String name;
    protected String protocol;
    protected String status;
    private static int deviceID;

    public static void setDeviceID(int deviceID) {
        Device.deviceID = deviceID;
    }

    public int getDeviceID() {
        return deviceID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
