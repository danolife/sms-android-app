package io.badr.sms.models;

public class Contact {
    private String phoneNumber;
    private String name;
    private String uniqueId;
    private String type;

    public Contact(String phoneNumber, String name, String uniqueId, String type) {
        this.setPhoneNumber(phoneNumber);
        this.name = name;
        this.uniqueId = uniqueId;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("\\s+", "");

        // Internationalization
        if (!(phoneNumber.startsWith("00") || phoneNumber.startsWith("+")) && phoneNumber.startsWith("0")) {
            phoneNumber = "+33" + phoneNumber.substring(1);
        }

        this.phoneNumber = phoneNumber;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getPhoneNumberWithoutSpecialChars() {
        return phoneNumber.replaceAll("\\+|-|\\(|\\)", "");
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (!this.getPhoneNumberWithoutSpecialChars().equals(contact.getPhoneNumberWithoutSpecialChars())) {
            return false;
        }
        return name.equals(contact.name);
    }

    @Override
    public int hashCode() {
        int result = getPhoneNumberWithoutSpecialChars().hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + uniqueId.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", uniqueId='" + uniqueId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
