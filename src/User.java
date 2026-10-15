public class User {
    private int id;
    private String email;
    private String whatsAppNo;

    public User(int id, String email, String whatsAppNo) {
        this.id = id;
        this.email = email;
        this.whatsAppNo = whatsAppNo;
    }

    @Override
    public String toString() {
        return "User" + id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWhatsAppNo() {
        return whatsAppNo;
    }

    public void setWhatsAppNo(String whatsAppNo) {
        this.whatsAppNo = whatsAppNo;
    }
}
