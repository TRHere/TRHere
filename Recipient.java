public class Recipient {
    private String name;
    private String bloodGroup;
    private String phone;
    private String city;

    public Recipient(String name, String bloodGroup, String phone, String city) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.phone = phone;
        this.city = city;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    @Override
    public String toString() {
        return "Recipient - Name: " + name + ", Blood Group: " + bloodGroup +
                ", Phone: " + phone + ", City: " + city;
    }
}
