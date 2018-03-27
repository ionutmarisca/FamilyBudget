package FamilyBudget.model;

public class Entry {
    private int value;
    private String typeEntry;//cost or income
    private int idMember;


    public Entry(String typeEntry, int value, int idM) {
        this.typeEntry = typeEntry;
        this.value = value;
        this.idMember = idM;
    }

    public String getType() {
        return typeEntry;
    }

    public void setType(String newType) {
        typeEntry = newType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        this.value = newValue;
    }

    public void setMember(int newMember) {
        this.idMember = newMember;
    }

    public int getIdMember() {
        return idMember;
    }

    public String toString() {
        return " idM=" + this.idMember + " " + this.typeEntry + " " + this.value;
    }

}
